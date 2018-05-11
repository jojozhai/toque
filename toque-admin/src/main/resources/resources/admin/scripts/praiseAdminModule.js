'use strict';
//平台管理模块的配置
angular.module('praiseAdminModule',[]).config(function($stateProvider) {
	//路由配置
	$stateProvider.state('index.praiseManage', {
		url: "/praiseManage",
		controller: "praiseManageCtrl",
		templateUrl: "admin/views/praiseManage.html"
	});
//服务配置
}).service("praiseRestService", function($resource, commonService){
	var config = commonService.getDefaultRestSetting();
	return $resource("praise/:id", {id:"@id"}, config);
//控制器
}).controller('praiseManageCtrl', function($scope, $uibModal, praiseRestService, commonService){
	
	$scope.pageInfo = commonService.getDefaultPageSetting();
	
	$scope.query = function() {
		var condition = commonService.buildPageCondition($scope.condition, $scope.pageInfo);
		
		var fcondition = condition;
		if(fcondition.createdTime) {
			fcondition.createdTime = fcondition.createdTime.format("yyyy-MM-dd");
		}
		
		if(fcondition.createdTimeTo) {
			fcondition.createdTimeTo = fcondition.createdTimeTo.format("yyyy-MM-dd");
		}
		
		praiseRestService.query(fcondition).$promise.then(function(data){
			$scope.pageInfo.totalElements = data.totalElements;
			$scope.praises = data.content;
		});
	}
	
	$scope.create = function() {
		$scope.save({
			createdTime:new Date()
		});
	}
	
	$scope.update = function(praise) {
		$scope.save(praise);
	}
	
	$scope.save = function(praise){
		$uibModal.open({
			size: "lg",
			templateUrl : 'admin/views/praiseForm.html',
			controller: 'praiseFormCtrl',
			resolve: {
		        praise : function() {return praise;},
			}
		}).result.then(function(form){
			if(form.id){
				new praiseRestService(form).$save().then(function(){
					commonService.showMessage("修改赞信息成功");
				},function(response){
					for (var i = 0; i < $scope.praises.length; i++) {
						if(form.id == $scope.praises[i].id) {
							$scope.praises[i] = praiseRestService.get({id:form.id});
							break;
						}
					}
				});
			}else{
				new praiseRestService(form).$create().then(function(praise){
					$scope.praises.unshift(praise);
					commonService.showMessage("新建赞信息成功");
				});
			}
		});
	}
	
	$scope.remove = function(praise) {
		commonService.showConfirm("您确认要删除此赞信息?").result.then(function() {
			praiseRestService.remove({id:praise.id}).$promise.then(function(result){
				commonService.showMessage("删除赞信息成功");
				$scope.praises.splice($scope.praises.indexOf(praise), 1);
				if($scope.praises.length == 0){
					$scope.pageInfo.page = $scope.pageInfo.page - 1;
					$scope.query();
				}
			})
		});
	} 
	
	$scope.cleanCondition = function() {
		$scope.condition = {};
		$scope.query();
	}
	
	$scope.query();
	
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

	$scope.changePage = function() {
		$scope.query();
	}
	
}).controller('praiseFormCtrl',function ($scope, $uibModalInstance, $translate, praise, commonService) {

	$scope.praise = praise;
	
	$scope.save = function(praise) {
		$uibModalInstance.close(praise);
	};
	
});