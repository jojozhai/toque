'use strict';
//平台管理模块的配置
angular.module('feedbackAdminModule',[]).config(function($stateProvider) {
	//路由配置
	$stateProvider.state('index.feedbackManage', {
		url: "/feedbackManage",
		controller: "feedbackManageCtrl",
		templateUrl: "admin/views/feedbackManage.html"
	});
//服务配置
}).service("feedbackRestService", function($resource, commonService){
	var config = commonService.getDefaultRestSetting();
	config.enable = {url:"feedback/:id/enable", method : "PUT"};
	config.disable = {url:"feedback/:id/disable", method : "PUT"};
	return $resource("feedback/:id", {id:"@id"}, config);
//控制器
}).controller('feedbackManageCtrl', function($scope, $uibModal, feedbackRestService, commonService){
	
	$scope.pageInfo = commonService.getDefaultPageSetting();
	
	$scope.query = function() {
		var condition = commonService.buildPageCondition($scope.condition, $scope.pageInfo);
		feedbackRestService.query(condition).$promise.then(function(data){
			$scope.pageInfo.totalElements = data.totalElements;
			$scope.feedbacks = data.content;
		});
	}
	
	$scope.create = function() {
		$scope.save({
			
		});
	}
	
	$scope.update = function(feedback) {
		$scope.save(feedback);
	}
	
	$scope.save = function(feedback){
		$uibModal.open({
			size: "lg",
			templateUrl : 'admin/views/feedbackForm.html',
			controller: 'feedbackFormCtrl',
			resolve: {
		        feedback : function() {return feedback;},
			}
		}).result.then(function(form){
			if(form.id){
				new feedbackRestService(form).$save().then(function(){
					form.status = 'replyed';
					commonService.showMessage("修改信息模板成功");
				},function(response){
					for (var i = 0; i < $scope.feedbacks.length; i++) {
						if(form.id == $scope.feedbacks[i].id) {
							$scope.feedbacks[i] = feedbackRestService.get({id:form.id});
							break;
						}
					}
				});
			}else{
				new feedbackRestService(form).$create().then(function(feedback){
					$scope.feedbacks.unshift(feedback);
					commonService.showMessage("新建信息模板成功");
				});
			}
		});
	}
	
	$scope.remove = function(feedback) {
		commonService.showConfirm("您确认要删除此信息模板?").result.then(function() {
			feedbackRestService.remove({id:feedback.id}).$promise.then(function(result){
				commonService.showMessage("删除信息模板成功");
				$scope.feedbacks.splice($scope.feedbacks.indexOf(feedback), 1);
				if($scope.feedbacks.length == 0){
					$scope.pageInfo.page = $scope.pageInfo.page - 1;
					$scope.query();
				}
			})
		});
	} 
	
	$scope.enable = function(feedback, enable) {
		feedback.enable = enable + "";
		if(enable){
			feedbackRestService.enable(feedback);
		}else{
			feedbackRestService.disable(feedback);
		}
	}
	
	$scope.cleanCondition = function() {
		$scope.condition = {};
		$scope.query();
	}
	
	$scope.query();

	$scope.changePage = function() {
		$scope.query();
	}
	
}).controller('feedbackFormCtrl',function ($scope, $uibModalInstance, $translate, feedback, commonService) {

	$scope.feedback = feedback;
	
	$scope.tinymceOptions = commonService.getDefaultTinymceOptions();
	
	$scope.save = function(feedback) {
		$uibModalInstance.close(feedback);
	};
	
	$scope.doUpload = function(files){
		commonService.uploadImage(files, $scope, function(result){
			$scope.feedback.topImage = result;
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
	
	$translate('feedback.scope.all').then(function (all) {
		$translate('feedback.scope.all.chef').then(function (allChef) {
			$translate('feedback.scope.all.trainee').then(function (allTrainee) {
				$scope.scopes = [{name:all,value:"ALL"}, {name:allChef,value:"ALL_CHEF"}, {name:allTrainee,value:"ALL_TRAINEE"}];
			});
		});
	});
	
	$translate('feedback.immediatelys.true').then(function (immediately) {
		$translate('feedback.immediatelys.false').then(function (unimmediately) {
			$scope.immediatelys = [{name:immediately,value:true}, {name:unimmediately,value:false}];
		});
	});
	
	
	
	
	
}).filter("feedbackStatus", function(){
	return function (data) {
		if(data == "waiting"){
			return 'feedback.status.waiting';
		}else if(data == "replyed"){
			return 'feedback.status.replyed';
		}else{
			return 'common.unknown';
		}
	}
});