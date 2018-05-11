'use strict';
//平台管理模块的配置
angular.module('lessonStatAdminModule',[]).config(function($stateProvider) {
	//路由配置
	$stateProvider.state('index.lessonStatManage', {
		url: "/lessonStatManage",
		controller: "lessonStatManageCtrl",
		templateUrl: "admin/views/lessonStatManage.html"
	});
//服务配置
}).service("lessonStatRestService", function($resource, commonService){
	var config = commonService.getDefaultRestSetting();
	return $resource("lessonStat/:id", {id:"@id"}, config);
//控制器
}).controller('lessonStatManageCtrl', function($scope, $uibModal, lessonStatRestService, commonService){
	
	$scope.pageInfo = commonService.getDefaultPageSetting();
	
	$scope.query = function() {
		var condition = commonService.buildPageCondition($scope.condition, $scope.pageInfo);
		lessonStatRestService.query(condition).$promise.then(function(data){
			$scope.pageInfo.totalElements = data.totalElements;
			$scope.lessonStats = data.content;
		});
	}
	
	$scope.create = function() {
		$scope.save({
			
		});
	}
	
	$scope.update = function(lessonStat) {
		$scope.save(lessonStat);
	}
	
	$scope.save = function(lessonStat){
		$uibModal.open({
			size: "lg",
			templateUrl : 'admin/views/lessonStatForm.html',
			controller: 'lessonStatFormCtrl',
			resolve: {
		        lessonStat : function() {return lessonStat;},
			}
		}).result.then(function(form){
			if(form.id){
				new lessonStatRestService(form).$save().then(function(){
					form.status = 'replyed';
					commonService.showMessage("修改信息模板成功");
				},function(response){
					for (var i = 0; i < $scope.lessonStats.length; i++) {
						if(form.id == $scope.lessonStats[i].id) {
							$scope.lessonStats[i] = lessonStatRestService.get({id:form.id});
							break;
						}
					}
				});
			}else{
				new lessonStatRestService(form).$create().then(function(lessonStat){
					$scope.lessonStats.unshift(lessonStat);
					commonService.showMessage("新建信息模板成功");
				});
			}
		});
	}
	
	$scope.remove = function(lessonStat) {
		commonService.showConfirm("您确认要删除此信息模板?").result.then(function() {
			lessonStatRestService.remove({id:lessonStat.id}).$promise.then(function(result){
				commonService.showMessage("删除信息模板成功");
				$scope.lessonStats.splice($scope.lessonStats.indexOf(lessonStat), 1);
				if($scope.lessonStats.length == 0){
					$scope.pageInfo.page = $scope.pageInfo.page - 1;
					$scope.query();
				}
			})
		});
	} 
	
	$scope.enable = function(lessonStat, enable) {
		lessonStat.enable = enable + "";
		if(enable){
			lessonStatRestService.enable(lessonStat);
		}else{
			lessonStatRestService.disable(lessonStat);
		}
	}
	
	$scope.cleanCondition = function() {
		$scope.condition = {scope : 'yesterday'};
		$scope.query();
	}
	
	$scope.cleanCondition();

	$scope.changePage = function() {
		$scope.query();
	}
	
	$scope.popup1 = {
		opened : false
	};
	
	$scope.popup2 = {
		opened : false
	};
	
	$scope.open1 = function() {
		$scope.popup1.opened = true;
	};
	
	$scope.open2 = function() {
		$scope.popup2.opened = true;
	};
	
	$scope.dateOptions = {
		startingDay : 1
	};
	
}).controller('lessonStatFormCtrl',function ($scope, $uibModalInstance, $translate, lessonStat, commonService) {

	$scope.lessonStat = lessonStat;
	
	$scope.tinymceOptions = commonService.getDefaultTinymceOptions();
	
	$scope.save = function(lessonStat) {
		$uibModalInstance.close(lessonStat);
	};
	
	$scope.doUpload = function(files){
		commonService.uploadImage(files, $scope, function(result){
			$scope.lessonStat.topImage = result;
		});
	}
	
	$scope.popup1 = {
		opened : false
	};
	
	$scope.open1 = function() {
		$scope.popup1.opened = true;
	};
	
	$scope.dateOptions = {
		startingDay : 1
	};
	
	$translate('lessonStat.scope.all').then(function (all) {
		$translate('lessonStat.scope.all.chef').then(function (allChef) {
			$translate('lessonStat.scope.all.trainee').then(function (allTrainee) {
				$scope.scopes = [{name:all,value:"ALL"}, {name:allChef,value:"ALL_CHEF"}, {name:allTrainee,value:"ALL_TRAINEE"}];
			});
		});
	});
	
	$translate('lessonStat.immediatelys.true').then(function (immediately) {
		$translate('lessonStat.immediatelys.false').then(function (unimmediately) {
			$scope.immediatelys = [{name:immediately,value:true}, {name:unimmediately,value:false}];
		});
	});
	
}).filter("lessonStatStatus", function(){
	return function (data) {
		if(data == "waiting"){
			return 'lessonStat.status.waiting';
		}else if(data == "replyed"){
			return 'lessonStat.status.replyed';
		}else{
			return 'common.unknown';
		}
	}
});