var app = angular.module('myApp', []);
app.controller('customersCtrl', [ '$scope', '$http', '$location',
		function($scope, $http) {
			$scope.clickSubmit = function() {
				/* alert("clicked!"); */
				$http({
					method : 'POST',
					responseType : 'json',
					dataType : "json",
					headers : {
						'Content-type' : 'application/json'
					},
					url : __ctx + "/account/user/login",
					data : JSON.stringify({
						name : $scope.name,
						password : $scope.password
					})
				}).success(function(data){
					if(JSON.stringify(data) == 0){
						alert("NAME OR PASSWORD ERROR");
					} else {
//						alert(JSON.stringify(data) + "\n" + "新增成功！");
						window.location.href = __ctx + "/index";
					}
				}).error(function(data,header,config,status){
					alert(data + "error");
				});
			}
		} ])
