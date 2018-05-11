'use strict';
//平台管理模块的配置
angular.module('messageAdminModule',[]).config(function($stateProvider) {
	//路由配置
	$stateProvider.state('index.messageManage', {
		url: "/messageManage",
		controller: "messageManageCtrl",
		templateUrl: "admin/views/messageManage.html"
	});
//服务配置
}).service("messageRestService", function($resource, commonService){
	var config = commonService.getDefaultRestSetting();
	return $resource("message/:id", {id:"@id"}, config);
//控制器
}).controller('messageManageCtrl', function($scope, $uibModal, messageRestService, commonService){
	
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
		
		messageRestService.query(fcondition).$promise.then(function(data){
			$scope.pageInfo.totalElements = data.totalElements;
			$scope.messages = data.content;
		});
	}
	
	$scope.create = function() {
		$scope.save({
			
		});
	}
	
	$scope.update = function(message) {
		$scope.save(message);
	}
	
	$scope.save = function(message){
		$uibModal.open({
			size: "lg",
			templateUrl : 'admin/views/messageForm.html',
			controller: 'messageFormCtrl',
			resolve: {
		        message : function() {return message;},
			}
		}).result.then(function(form){
			if(form.id){
				new messageRestService(form).$save().then(function(){
					form.status = 'replyed';
					commonService.showMessage("修改信息模板成功");
				},function(response){
					for (var i = 0; i < $scope.messages.length; i++) {
						if(form.id == $scope.messages[i].id) {
							$scope.messages[i] = messageRestService.get({id:form.id});
							break;
						}
					}
				});
			}else{
				new messageRestService(form).$create().then(function(message){
					$scope.messages.unshift(message);
					commonService.showMessage("新建信息模板成功");
				});
			}
		});
	}
	
	$scope.remove = function(message) {
		commonService.showConfirm("您确认要删除此信息模板?").result.then(function() {
			messageRestService.remove({id:message.id}).$promise.then(function(result){
				commonService.showMessage("删除信息模板成功");
				$scope.messages.splice($scope.messages.indexOf(message), 1);
				if($scope.messages.length == 0){
					$scope.pageInfo.page = $scope.pageInfo.page - 1;
					$scope.query();
				}
			})
		});
	} 
	
	$scope.enable = function(message, enable) {
		message.enable = enable + "";
		if(enable){
			messageRestService.enable(message);
		}else{
			messageRestService.disable(message);
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
	
}).controller('messageFormCtrl',function ($scope, $uibModalInstance, $translate, message, commonService) {

	$scope.message = message;
	
	$scope.tinymceOptions = commonService.getDefaultTinymceOptions();
	
	$scope.save = function(message) {
		$uibModalInstance.close(message);
	};
	
	$scope.doUpload = function(files){
		commonService.uploadImage(files, $scope, function(result){
			$scope.message.topImage = result;
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
	
	$translate('message.scope.all').then(function (all) {
		$translate('message.scope.all.chef').then(function (allChef) {
			$translate('message.scope.all.trainee').then(function (allTrainee) {
				$scope.scopes = [{name:all,value:"ALL"}, {name:allChef,value:"ALL_CHEF"}, {name:allTrainee,value:"ALL_TRAINEE"}];
			});
		});
	});
	
	$translate('message.immediatelys.true').then(function (immediately) {
		$translate('message.immediatelys.false').then(function (unimmediately) {
			$scope.immediatelys = [{name:immediately,value:true}, {name:unimmediately,value:false}];
		});
	});
	
}).filter("messageStatus", function(){
	return function (data) {
		if(data == "waiting"){
			return 'message.status.waiting';
		}else if(data == "replyed"){
			return 'message.status.replyed';
		}else{
			return 'common.unknown';
		}
	}
});