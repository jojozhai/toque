'use strict';
//平台管理模块的配置
angular.module('moduleAdminModule',['categoryAdminModule']).config(function($stateProvider) {
	//路由配置
	$stateProvider.state('index.moduleManage', {
		url: "/moduleManage",
		controller: "moduleManageCtrl",
		templateUrl: "admin/views/moduleManage.html"
	});
//服务配置
}).service("moduleRestService", function($resource, commonService){
	var config = commonService.getDefaultRestSetting();
	config.findAll = {url:"module/all", method : "GET", isArray : true};
	return $resource("module/:id", {id:"@id"}, config);
//控制器
}).controller('moduleManageCtrl', function($scope, $uibModal, moduleRestService, categoryRestService, commonService){
	
	$scope.pageInfo = commonService.getDefaultPageSetting();
	
	$scope.query = function() {
		var condition = commonService.buildPageCondition($scope.condition, $scope.pageInfo);
		moduleRestService.query(condition).$promise.then(function(data){
			$scope.pageInfo.totalElements = data.totalElements;
			$scope.modules = data.content;
		});
	}
	
	$scope.create = function() {
		$scope.save({
			createdTime:new Date(),
			type:"FREE"
		});
	}
	
	$scope.update = function(module) {
		$scope.save(module);
	}
	
	$scope.save = function(module){
		$uibModal.open({
			size: "lg",
			templateUrl : 'admin/views/moduleForm.html',
			controller: 'moduleFormCtrl',
			resolve: {
		        module : function() {return module;},
			}
		}).result.then(function(form){
			if(form.id){
				new moduleRestService(form).$save().then(function(){
					commonService.showMessage("修改门类信息成功");
				},function(response){
					for (var i = 0; i < $scope.modules.length; i++) {
						if(form.id == $scope.modules[i].id) {
							$scope.modules[i] = moduleRestService.get({id:form.id});
							break;
						}
					}
				});
			}else{
				new moduleRestService(form).$create().then(function(module){
					$scope.modules.unshift(module);
					commonService.showMessage("新建门类信息成功");
				});
			}
		});
	}
	
	$scope.remove = function(module) {
		commonService.showConfirm("您确认要删除此门类信息?").result.then(function() {
			moduleRestService.remove({id:module.id}).$promise.then(function(result){
				commonService.showMessage("删除门类信息成功");
				$scope.modules.splice($scope.modules.indexOf(module), 1);
				if($scope.modules.length == 0){
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

	$scope.changePage = function() {
		$scope.query();
	}
	
}).controller('moduleFormCtrl',function ($scope, $uibModalInstance, $translate, module, categoryRestService, commonService) {

	module.categoryId = module.categoryId + '';
	$scope.module = module;
	
	categoryRestService.findAll().$promise.then(function(data){
		$scope.categorys = data;
	});
	
	$scope.save = function(module) {
		$uibModalInstance.close(module);
	};
	
}).filter("moduleTypes", function(){
	return function (data) {
		if(data == "FREE"){
			return 'module.type.free';
		}else if(data == "PAY"){
			return 'module.type.pay';
		}else if(data == "HOT"){
			return 'module.type.hot';
		}else{
			return 'common.unknown';
		}
	}
});