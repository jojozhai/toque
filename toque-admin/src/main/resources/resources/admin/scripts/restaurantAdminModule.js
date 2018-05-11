'use strict';
//平台管理模块的配置
angular.module('restaurantAdminModule',[]).config(function($stateProvider) {
	//路由配置
	$stateProvider.state('index.restaurantManage', {
		url: "/restaurantManage",
		controller: "restaurantManageCtrl",
		templateUrl: "admin/views/restaurantManage.html"
	}).state('index.restaurantStatManage', {
		url: "/restaurantStatManage",
		controller: "restaurantStatManageCtrl",
		templateUrl: "admin/views/restaurantStatManage.html"
	});
//服务配置
}).service("restaurantRestService", function($resource, commonService){
	var config = commonService.getDefaultRestSetting();
	config.stat = {url:"restaurant/stat", method : "GET"};
	return $resource("restaurant/:id", {id:"@id"}, config);
//控制器
}).controller('restaurantManageCtrl', function($scope, $uibModal, restaurantRestService, commonService){
	
	$scope.pageInfo = commonService.getDefaultPageSetting();
	
	$scope.query = function() {
		var condition = commonService.buildPageCondition($scope.condition, $scope.pageInfo);
		restaurantRestService.query(condition).$promise.then(function(data){
			$scope.pageInfo.totalElements = data.totalElements;
			$scope.restaurants = data.content;
		});
	}
	
	$scope.create = function() {
		$scope.save({
			
		});
	}
	
	$scope.update = function(restaurant) {
		$scope.save(restaurant);
	}
	
	$scope.save = function(restaurant){
		$uibModal.open({
			size: "lg",
			restaurantUrl : 'admin/views/restaurantForm.html',
			controller: 'restaurantFormCtrl',
			resolve: {
		        restaurant : function() {return restaurant;},
			}
		}).result.then(function(form){
			if(form.id){
				new restaurantRestService(form).$save().then(function(){
					commonService.showMessage("修改餐厅信息成功");
				},function(response){
					for (var i = 0; i < $scope.restaurants.length; i++) {
						if(form.id == $scope.restaurants[i].id) {
							$scope.restaurants[i] = restaurantRestService.get({id:form.id});
							break;
						}
					}
				});
			}else{
				new restaurantRestService(form).$create().then(function(restaurant){
					$scope.restaurants.unshift(restaurant);
					commonService.showMessage("新建餐厅信息成功");
				});
			}
		});
	}
	
	$scope.remove = function(restaurant) {
		commonService.showConfirm("您确认要删除此餐厅信息?").result.then(function() {
			restaurantRestService.remove({id:restaurant.id}).$promise.then(function(result){
				commonService.showMessage("删除餐厅信息成功");
				$scope.restaurants.splice($scope.restaurants.indexOf(restaurant), 1);
				if($scope.restaurants.length == 0){
					$scope.pageInfo.page = $scope.pageInfo.page - 1;
					$scope.query();
				}
			})
		});
	} 
	
	$scope.enable = function(restaurant, enable) {
		console.log(restaurant.enable);
		restaurant.enable = enable + "";
		console.log(restaurant.enable);
	}
	
	$scope.cleanCondition = function() {
		$scope.condition = {};
		$scope.query();
	}
	
	$scope.query();

	$scope.changePage = function() {
		$scope.query();
	}
	
}).controller('restaurantStatManageCtrl', function($scope, $uibModal, restaurantRestService, commonService){
	
	$scope.pageInfo = commonService.getDefaultPageSetting();
	
	$scope.query = function() {
		var condition = commonService.buildPageCondition($scope.condition, $scope.pageInfo);
		restaurantRestService.stat(condition).$promise.then(function(data){
			$scope.pageInfo.totalElements = data.totalElements;
			$scope.restaurants = data.content;
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
	
}).controller('restaurantFormCtrl',function ($scope, $uibModalInstance, $translate, restaurant, commonService) {

	$scope.restaurant = restaurant;
	
	$scope.tinymceOptions = commonService.getDefaultTinymceOptions();
	
	$scope.save = function(restaurant) {
		$uibModalInstance.close(restaurant);
	};
	
	$scope.doUpload = function(files){
		commonService.uploadImage(files, $scope, function(result){
			$scope.restaurant.topImage = result;
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
	
	
}).filter("restaurantEnables", function(){
	return function (data) {
		if(data + "" == "true"){
			return 'restaurant.enable.true';
		}else if(data + "" == "false"){
			return 'restaurant.enable.false';
		}else{
			return 'common.unknown';
		}
	}
}).filter("restaurantPays", function(){
	return function (data) {
		if(data + "" == "true"){
			return 'restaurant.pay.true';
		}else if(data +"" == "false"){
			return 'restaurant.pay.false';
		}else{
			return 'common.unknown';
		}
	}
}).filter("restaurantLevels", function(){
	return function (data) {
		if(data + "" == "VIP0"){
			return 'restaurant.level.vip0';
		}else if(data +"" == "VIP1"){
			return 'restaurant.level.vip1';
		}else if(data +"" == "VIP2"){
			return 'restaurant.level.vip2';
		}else if(data +"" == "VIP3"){
			return 'restaurant.level.vip3';
		}else if(data +"" == "VIP4"){
			return 'restaurant.level.vip4';
		}else{
			return 'common.unknown';
		}
	}
});