'use strict';
//平台管理模块的配置
angular.module('videoSetAdminModule',[]).config(function($stateProvider) {
	//路由配置
	$stateProvider.state('index.videoSetManage', {
		url: "/videoSetManage",
		controller: "videoSetManageCtrl",
		templateUrl: "admin/views/videoSetManage.html"
	});
//服务配置
}).service("videoSetRestService", function($resource, commonService){
	var config = commonService.getDefaultRestSetting();
	config.findAll = {url:"videoSet/all", method : "GET", isArray : true};
	return $resource("videoSet/:id", {id:"@id"}, config);
//控制器
}).controller('videoSetManageCtrl', function($scope, $uibModal, videoSetRestService, commonService){
	
	$scope.pageInfo = commonService.getDefaultPageSetting();
	
	$scope.query = function() {
		var condition = commonService.buildPageCondition($scope.condition, $scope.pageInfo);
		videoSetRestService.query(condition).$promise.then(function(data){
			$scope.pageInfo.totalElements = data.totalElements;
			$scope.videoSets = data.content;
		});
	}
	
	$scope.create2 = function() {
		$scope.save({
			startWithImage:true,
			createdTime: new Date(),
			groups:[{
				type:"SELECT",
				videos:[{},{},{}]
			}]
		});
	}
	
	$scope.create = function() {
		$scope.save({
			startWithImage:false,
			createdTime: new Date()
		});
	}
	
	$scope.update = function(videoSet) {
		videoSetRestService.get(videoSet).$promise.then(function(data){
			$scope.save(data);
		});
	}
	
	$scope.save = function(videoSet){
		$uibModal.open({
			size: "lg",
			templateUrl : 'admin/views/videoSetForm.html',
			controller: 'videoSetFormCtrl',
			resolve: {
		        videoSet : function() {return videoSet;},
			}
		}).result.then(function(form){
			if(form.id){
				new videoSetRestService(form).$save().then(function(){
					commonService.showMessage("修改视频集信息成功");
					for (var i = 0; i < $scope.videoSets.length; i++) {
						if(form.id == $scope.videoSets[i].id) {
							$scope.videoSets[i] = form;
							break;
						}
					}
				},function(response){
					for (var i = 0; i < $scope.videoSets.length; i++) {
						if(form.id == $scope.videoSets[i].id) {
							$scope.videoSets[i] = videoSetRestService.get({id:form.id});
							break;
						}
					}
				});
			}else{
				new videoSetRestService(form).$create().then(function(videoSet){
					$scope.videoSets.unshift(videoSet);
					commonService.showMessage("新建视频集信息成功");
				});
			}
		});
	}
	
	$scope.remove = function(videoSet) {
		commonService.showConfirm("您确认要删除此视频集信息?").result.then(function() {
			videoSetRestService.remove({id:videoSet.id}).$promise.then(function(result){
				commonService.showMessage("删除视频集信息成功");
				$scope.videoSets.splice($scope.videoSets.indexOf(videoSet), 1);
				if($scope.videoSets.length == 0){
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
	
}).controller('videoSetFormCtrl',function ($scope, $uibModalInstance, $translate, videoSet, commonService) {
	
	$scope.videoSet = videoSet;
	
	$scope.save = function(videoSet) {
		$uibModalInstance.close(videoSet);
	};
	
	$scope.createTemplate = function() {
		
		var videoSet = $scope.videoSet;
		
		videoSet.groups = [{
			type:"MAIN",
			videos:[]
		}];
		
		for (var i = 0; i < videoSet.rightCount; i++) {
			videoSet.groups.push({
				type:"JUDGE",
				rightOption:"A",
				videos:[{},{}]
			});
		}
		
		for (var i = 0; i < videoSet.multiCount; i++) {
			videoSet.groups.push({
				type:"SELECT",
				videos:[{},{},{}]
			});
		}
		
	};
	
	$scope.addVideo = function(videoGroup) {
		if(videoGroup.videos.length >= 10){
			commonService.showError("一组视频不能超过10个");
		}else{
			videoGroup.videos.push({});
		}
	}
	
	$scope.resetGroup = function(videoGroup){
		videoGroup.image = "";
		videoGroup.videos = [{},{},{}];
	}
	
	$scope.letters = ["A","B","C","D","E","F","G","H","I","J"];
	
}).filter("startTypes", function(){
	return function (data) {
		if(data + "" == "true"){
			return 'videoSet.startWithImage.true';
		}else if(data +"" == "false"){
			return 'videoSet.startWithImage.false';
		}else{
			return 'common.unknown';
		}
	}
});