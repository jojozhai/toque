'use strict';
//应用主模块
angular.module('adminAppSingin',[]).controller('signinCtrl', function ($scope, $http) {
    $scope.signin = function () {
        $http.post("authentication/form?username=" + $scope.user.username + "&password=" + $scope.user.password).success(function (response) {
            window.location.href = "manage.html#/index/firstPageManage";
        }).error(function (res) {
        	console.log(res);
            alert("用户名或密码错误");
        });
    }
});