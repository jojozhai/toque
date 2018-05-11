'use strict';
//平台管理模块的配置
angular.module('rankAdminModule',[]).config(function($stateProvider) {
	//路由配置
	$stateProvider.state('index.rankManage', {
		url: "/rankManage",
		controller: "rankManageCtrl",
		templateUrl: "admin/views/rankManage.html"
	});
//服务配置
}).service("rankRestService", function($resource, commonService){
	var config = commonService.getDefaultRestSetting();
	return $resource("rank/:id", {id:"@id"}, config);
//控制器
}).controller('rankManageCtrl', function($scope, $uibModal, rankRestService, commonService){
	
	
	
}).controller('rankFormCtrl',function ($scope, $uibModalInstance, $translate, rank, commonService) {

	$scope.rank = rank;
	
	$scope.tinymceOptions = commonService.getDefaultTinymceOptions();
	
	$scope.save = function(rank) {
		$uibModalInstance.close(rank);
	};
	
	$scope.doUpload = function(files){
		commonService.uploadImage(files, $scope, function(result){
			$scope.rank.topImage = result;
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
	
	$translate('rank.scope.all').then(function (all) {
		$translate('rank.scope.all.chef').then(function (allChef) {
			$translate('rank.scope.all.trainee').then(function (allTrainee) {
				$scope.scopes = [{name:all,value:"ALL"}, {name:allChef,value:"ALL_CHEF"}, {name:allTrainee,value:"ALL_TRAINEE"}];
			});
		});
	});
	
	$translate('rank.immediatelys.true').then(function (immediately) {
		$translate('rank.immediatelys.false').then(function (unimmediately) {
			$scope.immediatelys = [{name:immediately,value:true}, {name:unimmediately,value:false}];
		});
	});
	
	$scope.changePage = function() {
		$scope.query();
	}
	
	
	
}).filter("rankScopes", function(){
	return function (data) {
		if(data == "ALL"){
			return 'rank.scope.all';
		}else if(data == "ALL_CHEF"){
			return 'rank.scope.all.chef';
		}else if(data == "ALL_TRAINEE"){
			return 'rank.scope.all.trainee';
		}else if(data == "SINGLE"){
			return 'rank.scope.single';
		}else{
			return 'common.unknown';
		}
	}
}).filter("rankImmediatelys", function(){
	return function (data) {
		if(data + "" == "true"){
			return 'rank.immediatelys.true';
		}else if(data +"" == "false"){
			return 'rank.immediatelys.false';
		}else{
			return 'common.unknown';
		}
	}
}).filter("rankTypes", function(){
	return function (data) {
		if(data == "CUSTOM"){
			return 'rank.type.custom';
		}else if(data == "TEAM_APPLY"){
			return 'rank.type.team.apply';
		}else if(data == "TEAM_INVITE"){
			return 'rank.type.team.invite';
		}else if(data == "NEW_LESSON_ASSIGN"){
			return 'rank.type.new.lesson.assign';
		}else if(data == "TRAINEE_REGIST_SUCCESS"){
			return 'rank.type.trainee.regist.success';
		}else if(data == "CHEF_REGIST_SUCCESS"){
			return 'rank.type.chef.regist.success';
		}else{
			return 'common.unknown';
		}
	}
});