'use strict';
//平台管理模块的配置
angular.module('statisticsAdminModule',[]).config(function($stateProvider) {
	//路由配置
	$stateProvider.state('index.statNewUser', {
		url: "/statNewUser",
		controller: "statNewUserCtrl",
		templateUrl: "admin/views/statNewUser.html"
	}).state('index.statActiveUser', {
		url: "/statActiveUser",
		controller: "statActiveUserCtrl",
		templateUrl: "admin/views/statActiveUser.html"
	}).state('index.statPayUser', {
		url: "/statPayUser",
		controller: "statPayUserCtrl",
		templateUrl: "admin/views/statPayUser.html"
	});
//服务配置
}).service("statisticsRestService", function($resource, commonService){
	var config = commonService.getDefaultRestSetting();
	config.newUser = {url:"statistics/user/new", method : "POST"};
	config.activeUser = {url:"statistics/user/active", method : "POST"};
	config.payUser = {url:"statistics/user/pay", method : "POST"};
	return $resource("statistics/:id", {id:"@id"}, config);
//控制器
}).controller('statNewUserCtrl', function($scope, $uibModal, statisticsRestService, commonService){
	
	$scope.initCondition = function() {
		var now = new Date();
		now.setDate(now.getDate()-1);
		var sevenDayAgo = new Date();
		sevenDayAgo.setDate(sevenDayAgo.getDate()-7);
		
		$scope.condition = {
			startTime:sevenDayAgo,
			endTime:now
		};
	}
	
	$scope.initCondition();
	
	
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
	
	$scope.query = function() {
		statisticsRestService.newUser($scope.condition).$promise.then(function(data){
			$scope.stat = data;
		});
	}
	
	$scope.cleanCondition = function() {
		$scope.initCondition();
		$scope.query();
	}
	
	$scope.query();

	$scope.changePage = function() {
		$scope.query();
	}
	
}).controller('statActiveUserCtrl', function($scope, $uibModal, statisticsRestService, commonService){
	
	$scope.initCondition = function() {
		var now = new Date();
		now.setDate(now.getDate()-1);
		var sevenDayAgo = new Date();
		sevenDayAgo.setDate(sevenDayAgo.getDate()-7);
		
		$scope.condition = {
			startTime:sevenDayAgo,
			endTime:now,
			statUnit:'day'
		};
	}
	
	$scope.initCondition();
	
	
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
	
	$scope.query = function() {
		statisticsRestService.activeUser($scope.condition).$promise.then(function(data){
			$scope.stat = data;
		});
	}
	
	$scope.cleanCondition = function() {
		$scope.initCondition();
		$scope.query();
	}
	
	$scope.query();
	
}).controller('statPayUserCtrl', function($scope, $uibModal, statisticsRestService, commonService){
	
	$scope.initCondition = function() {
		var now = new Date();
		now.setDate(now.getDate()-1);
		var sevenDayAgo = new Date();
		sevenDayAgo.setDate(sevenDayAgo.getDate()-7);
		
		$scope.condition = {
			startTime:sevenDayAgo,
			endTime:now
		};
	}
	
	$scope.initCondition();
	
	
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
	
	$scope.query = function() {
		statisticsRestService.payUser($scope.condition).$promise.then(function(data){
			$scope.stat = data;
		});
	}
	
	$scope.cleanCondition = function() {
		$scope.initCondition();
		$scope.query();
	}
	
	$scope.query();
	
});