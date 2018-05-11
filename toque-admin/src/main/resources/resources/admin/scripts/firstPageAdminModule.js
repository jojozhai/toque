'use strict';
//平台管理模块的配置
angular.module('firstPageAdminModule',[]).config(function($stateProvider) {
	//路由配置
	$stateProvider.state('index.firstPageManage', {
		url: "/firstPageManage",
		controller: "firstPageManageCtrl",
		templateUrl: "admin/views/firstPage.html"
	});
//服务配置
}).service("firstPageRestService", function($resource, commonService){
	var config = commonService.getDefaultRestSetting();
	config.statistics = {url:"statistics/index", method : "GET"};
	return $resource("user/:id", {id:"@id"}, config);
//控制器
}).controller('firstPageManageCtrl', function($scope, $uibModal, firstPageRestService, commonService){
	
	firstPageRestService.statistics().$promise.then(function(data){
		$scope.stat = data;
	});
	
});