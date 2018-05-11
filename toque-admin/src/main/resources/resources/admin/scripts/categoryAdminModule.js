'use strict';
//平台管理模块的配置
angular.module('categoryAdminModule',[]).config(function($stateProvider) {
	//路由配置
	$stateProvider.state('index.categoryManage', {
		url: "/categoryManage",
		controller: "categoryManageCtrl",
		templateUrl: "admin/views/categoryManage.html"
	});
//服务配置
}).service("categoryRestService", function($resource, commonService){
	var config = commonService.getDefaultRestSetting();
	config.findAll = {url:"category/all", method : "GET", isArray : true};
	return $resource("category/:id", {id:"@id"}, config);
//控制器
}).controller('categoryManageCtrl', function($scope, $uibModal, categoryRestService, commonService){
	
	$scope.pageInfo = commonService.getDefaultPageSetting();
	
	$scope.query = function() {
		var condition = commonService.buildPageCondition($scope.condition, $scope.pageInfo);
		categoryRestService.query(condition).$promise.then(function(data){
			$scope.pageInfo.totalElements = data.totalElements;
			$scope.categorys = data.content;
		});
	}
	
	$scope.create = function() {
		$scope.save({
			createdTime:new Date()
		});
	}
	
	$scope.update = function(category) {
		$scope.save(category);
	}
	
	$scope.save = function(category){
		$uibModal.open({
			size: "lg",
			templateUrl : 'admin/views/categoryForm.html',
			controller: 'categoryFormCtrl',
			resolve: {
		        category : function() {return category;},
			}
		}).result.then(function(form){
			if(form.id){
				new categoryRestService(form).$save().then(function(){
					commonService.showMessage("修改门类信息成功");
				},function(response){
					for (var i = 0; i < $scope.categorys.length; i++) {
						if(form.id == $scope.categorys[i].id) {
							$scope.categorys[i] = categoryRestService.get({id:form.id});
							break;
						}
					}
				});
			}else{
				new categoryRestService(form).$create().then(function(category){
					$scope.categorys.unshift(category);
					commonService.showMessage("新建门类信息成功");
				});
			}
		});
	}
	
	$scope.remove = function(category) {
		commonService.showConfirm("您确认要删除此门类信息?").result.then(function() {
			categoryRestService.remove({id:category.id}).$promise.then(function(result){
				commonService.showMessage("删除门类信息成功");
				$scope.categorys.splice($scope.categorys.indexOf(category), 1);
				if($scope.categorys.length == 0){
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
	
}).controller('categoryFormCtrl',function ($scope, $uibModalInstance, $translate, category, commonService) {

	$scope.category = category;
	
	$scope.save = function(category) {
		$uibModalInstance.close(category);
	};
	
});