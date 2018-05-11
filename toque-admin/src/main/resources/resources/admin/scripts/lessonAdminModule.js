'use strict';
//平台管理模块的配置
angular.module('lessonAdminModule', ['moduleAdminModule','videoSetAdminModule',]).config(function($stateProvider) {
	//路由配置
	$stateProvider.state('index.lessonManage', {
		url: "/lessonManage",
		controller: "lessonManageCtrl",
		templateUrl: "admin/views/lessonManage.html"
	});
//服务配置
}).service("lessonRestService", function($resource, commonService){
	var config = commonService.getDefaultRestSetting();
	config.enable = {url:"lesson/:id/enable", method : "PUT"};
	config.disable = {url:"lesson/:id/disable", method : "PUT"};
	return $resource("lesson/:id", {id:"@id"}, config);
//控制器
}).controller('lessonManageCtrl', function($scope, $uibModal, lessonRestService, commonService){
	
	$scope.pageInfo = commonService.getDefaultPageSetting();
	
	$scope.query = function() {
		var condition = commonService.buildPageCondition($scope.condition, $scope.pageInfo);
		lessonRestService.query(condition).$promise.then(function(data){
			$scope.pageInfo.totalElements = data.totalElements;
			$scope.lessons = data.content;
		});
	}
	
	$scope.create = function() {
		$scope.save({
			createdTime:new Date(),
			difficulty:"EASY",
			steps:[],
			stepsE:[]
		});
	}
	
	$scope.update = function(lesson) {
		lessonRestService.get(lesson).$promise.then(function(data){
			$scope.save(data);
		});
	}
	
	$scope.save = function(lesson){
		$uibModal.open({
			size: "lg",
			templateUrl : 'admin/views/lessonForm.html',
			controller: 'lessonFormCtrl',
			resolve: {
		        lesson : function() {return lesson;},
			}
		}).result.then(function(form){
			if(form.id){
				new lessonRestService(form).$save().then(function(){
					commonService.showMessage("修改课程信息成功");
					for (var i = 0; i < $scope.lessons.length; i++) {
						if(form.id == $scope.lessons[i].id) {
							$scope.lessons[i] = form;
							break;
						}
					}
				},function(response){
					for (var i = 0; i < $scope.lessons.length; i++) {
						if(form.id == $scope.lessons[i].id) {
							$scope.lessons[i] = lessonRestService.get({id:form.id});
							break;
						}
					}
				});
			}else{
				new lessonRestService(form).$create().then(function(lesson){
					$scope.lessons.unshift(lesson);
					commonService.showMessage("新建课程信息成功");
				});
			}
		});
	}
	
	$scope.remove = function(lesson) {
		commonService.showConfirm("您确认要删除此课程信息?").result.then(function() {
			lessonRestService.remove({id:lesson.id}).$promise.then(function(result){
				commonService.showMessage("删除课程信息成功");
				$scope.lessons.splice($scope.lessons.indexOf(lesson), 1);
				if($scope.lessons.length == 0){
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
	
	$scope.enable = function(lesson, enable) {
		lesson.enable = enable + "";
		if(enable){
			lessonRestService.enable(lesson);
		}else{
			lessonRestService.disable(lesson);
		}
	}
	
}).controller('lessonFormCtrl',function ($scope, $uibModalInstance, $translate, lesson, moduleRestService, videoSetRestService, commonService) {

	lesson.moduleId = lesson.moduleId + '';
	lesson.videoSetId = lesson.videoSetId + '';
	$scope.lesson = lesson;
	
	$scope.changeSecond = function() {
		var value = $scope.lesson.second + "";
		if (value.length > 4) {
			$scope.lesson.second = parseInt(value.slice(0,4)); 
		}
	}
	
	$scope.save = function(lesson) {
		$uibModalInstance.close(lesson);
	};
	
	moduleRestService.findAll().$promise.then(function(data){
		$scope.modules = data;
	});
	
	videoSetRestService.findAll().$promise.then(function(data){
		$scope.videoSets = data;
	});
	
	$scope.addStep = function(newStep){
		$scope.lesson.steps.push(newStep);
		$scope.newStep = {};
	}
	
	$scope.removeStep = function(step){
		$scope.lesson.steps.splice($scope.lesson.steps.indexOf(step), 1);
	}
	
	$scope.addStepE = function(newStep){
		$scope.lesson.stepsE.push(newStep);
		$scope.newStepE = {};
	}
	
	$scope.removeStepE = function(step){
		$scope.lesson.stepsE.splice($scope.lesson.stepsE.indexOf(step), 1);
	}
	
}).filter("lessonDifficultys", function(){
	return function (data) {
		if(data + "" == "EASY"){
			return 'lesson.difficulty.easy';
		}else if(data +"" == "NORMAL"){
			return 'lesson.difficulty.normal';
		}else if(data +"" == "HARD"){
			return 'lesson.difficulty.hard';
		}else{
			return 'common.unknown';
		}
	}
});