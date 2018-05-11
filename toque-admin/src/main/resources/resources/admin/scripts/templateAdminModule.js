'use strict';
//平台管理模块的配置
angular.module('templateAdminModule',[]).config(function($stateProvider) {
	//路由配置
	$stateProvider.state('index.templateManage', {
		url: "/templateManage",
		controller: "templateManageCtrl",
		templateUrl: "admin/views/templateManage.html"
	});
//服务配置
}).service("templateRestService", function($resource, commonService){
	var config = commonService.getDefaultRestSetting();
	config.enable = {url:"template/:id/enable", method : "PUT"};
	config.disable = {url:"template/:id/disable", method : "PUT"};
	return $resource("template/:id", {id:"@id"}, config);
//控制器
}).controller('templateManageCtrl', function($scope, $uibModal, templateRestService, commonService){
	
	$scope.pageInfo = commonService.getDefaultPageSetting();
	
	$scope.query = function() {
		var condition = commonService.buildPageCondition($scope.condition, $scope.pageInfo);
		templateRestService.query(condition).$promise.then(function(data){
			$scope.pageInfo.totalElements = data.totalElements;
			$scope.templates = data.content;
		});
	}
	
	$scope.create = function() {
		$scope.save({
			immediately:true,
			scope:"ALL",
			type:"CUSTOM",
			sendSmsAndEmail:false
//			organ:false
		});
	}
	
	$scope.update = function(template) {
		$scope.save(template);
	}
	
	$scope.save = function(template){
		$uibModal.open({
			size: "lg",
			templateUrl : 'admin/views/templateForm.html',
			controller: 'templateFormCtrl',
			resolve: {
		        template : function() {return template;},
			}
		}).result.then(function(form){
			if(form.id){
				new templateRestService(form).$save().then(function(){
					commonService.showMessage("修改信息模板成功");
				},function(response){
					for (var i = 0; i < $scope.templates.length; i++) {
						if(form.id == $scope.templates[i].id) {
							$scope.templates[i] = templateRestService.get({id:form.id});
							break;
						}
					}
				});
			}else{
				new templateRestService(form).$create().then(function(template){
					$scope.templates.unshift(template);
					commonService.showMessage("新建信息模板成功");
				});
			}
		});
	}
	
	$scope.remove = function(template) {
		commonService.showConfirm("您确认要删除此信息模板?").result.then(function() {
			templateRestService.remove({id:template.id}).$promise.then(function(result){
				commonService.showMessage("删除信息模板成功");
				$scope.templates.splice($scope.templates.indexOf(template), 1);
				if($scope.templates.length == 0){
					$scope.pageInfo.page = $scope.pageInfo.page - 1;
					$scope.query();
				}
			})
		});
	} 
	
	$scope.enable = function(template, enable) {
		template.enable = enable + "";
		if(enable){
			templateRestService.enable(template);
		}else{
			templateRestService.disable(template);
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
	
}).controller('templateFormCtrl',function ($scope, $uibModalInstance, $translate, template, commonService) {

	$scope.template = template;
	
	$scope.tinymceOptions = commonService.getDefaultTinymceOptions();
	
	$scope.save = function(template) {
		$uibModalInstance.close(template);
	};
	
	$scope.doUpload = function(files){
		commonService.uploadImage(files, $scope, function(result){
			$scope.template.topImage = result;
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
	
	$translate('template.scope.all').then(function (all) {
		$translate('template.scope.all.chef').then(function (allChef) {
			$translate('template.scope.all.trainee').then(function (allTrainee) {
				$scope.scopes = [{name:all,value:"ALL"}, {name:allChef,value:"ALL_CHEF"}, {name:allTrainee,value:"ALL_TRAINEE"}];
			});
		});
	});
	
	$translate('template.immediatelys.true').then(function (immediately) {
		$translate('template.immediatelys.false').then(function (unimmediately) {
			$scope.immediatelys = [{name:immediately,value:true}, {name:unimmediately,value:false}];
		});
	});
	
}).filter("templateScopes", function(){
	return function (data) {
		if(data == "ALL"){
			return 'template.scope.all';
		}else if(data == "ALL_CHEF"){
			return 'template.scope.all.chef';
		}else if(data == "ALL_TRAINEE"){
			return 'template.scope.all.trainee';
		}else if(data == "SINGLE"){
			return 'template.scope.single';
		}else{
			return 'common.unknown';
		}
	}
}).filter("templateImmediatelys", function(){
	return function (data) {
		if(data + "" == "true"){
			return 'template.immediatelys.true';
		}else if(data +"" == "false"){
			return 'template.immediatelys.false';
		}else{
			return 'common.unknown';
		}
	}
});