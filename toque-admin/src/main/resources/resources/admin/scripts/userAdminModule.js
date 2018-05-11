'use strict';
//平台管理模块的配置
angular.module('userAdminModule',[]).config(function($stateProvider) {
	//路由配置
	$stateProvider.state('index.userManage', {
		url: "/userManage",
		controller: "userManageCtrl",
		templateUrl: "admin/views/userManage.html"
	});
//服务配置
}).service("userRestService", function($resource, commonService){
	var config = commonService.getDefaultRestSetting();
	return $resource("user/:id", {id:"@id"}, config);
//控制器
}).controller('userManageCtrl', function($scope, $uibModal, userRestService, commonService){
	
	$scope.pageInfo = commonService.getDefaultPageSetting();
	
	$scope.query = function() {
		var condition = commonService.buildPageCondition($scope.condition, $scope.pageInfo);
		userRestService.query(condition).$promise.then(function(data){
			$scope.pageInfo.totalElements = data.totalElements;
			$scope.users = data.content;
		});
	}
	
	$scope.create = function() {
		$scope.save({
			
		});
	}
	
	$scope.update = function(user) {
		$scope.save(user);
	}
	
	$scope.save = function(user){
		$uibModal.open({
			size: "lg",
			userUrl : 'admin/views/userForm.html',
			controller: 'userFormCtrl',
			resolve: {
		        user : function() {return user;},
			}
		}).result.then(function(form){
			if(form.id){
				new userRestService(form).$save().then(function(){
					commonService.showMessage("修改用户信息成功");
				},function(response){
					for (var i = 0; i < $scope.users.length; i++) {
						if(form.id == $scope.users[i].id) {
							$scope.users[i] = userRestService.get({id:form.id});
							break;
						}
					}
				});
			}else{
				new userRestService(form).$create().then(function(user){
					$scope.users.unshift(user);
					commonService.showMessage("新建用户信息成功");
				});
			}
		});
	}
	
	$scope.remove = function(user) {
		commonService.showConfirm("您确认要删除此用户信息?").result.then(function() {
			userRestService.remove({id:user.id}).$promise.then(function(result){
				commonService.showMessage("删除用户信息成功");
				$scope.users.splice($scope.users.indexOf(user), 1);
				if($scope.users.length == 0){
					$scope.pageInfo.page = $scope.pageInfo.page - 1;
					$scope.query();
				}
			})
		});
	} 
	
	$scope.enable = function(user, enable) {
		console.log(user.enable);
		user.enable = enable + "";
		console.log(user.enable);
	}
	
	$scope.cleanCondition = function() {
		$scope.condition = {};
		$scope.query();
	}
	
	$scope.query();

	$scope.changePage = function() {
		$scope.query();
	}
	
}).controller('userFormCtrl',function ($scope, $uibModalInstance, $translate, user, commonService) {

}).filter("userEnables", function(){
	return function (data) {
		if(data + "" == "true"){
			return 'user.enable.true';
		}else if(data + "" == "false"){
			return 'user.enable.false';
		}else{
			return 'common.unknown';
		}
	}
}).filter("userTypes", function(){
	return function (data) {
		if(data + "" == "CHEF"){
			return 'user.userType.chef';
		}else if(data +"" == "TRAINEE"){
			return 'user.userType.trainee';
		}else{
			return 'common.unknown';
		}
	}
}).filter("languageTypes", function(){
	return function (data) {
		if(data + "" == "CHINESE"){
			return 'user.languageType.chinese';
		}else if(data +"" == "ENGLISH"){
			return 'user.languageType.english';
		}else{
			return 'common.unknown';
		}
	}
});