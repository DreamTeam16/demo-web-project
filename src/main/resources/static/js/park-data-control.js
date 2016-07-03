var cs480App = angular.module('cs480App', []);

cs480App.controller('ParkCtrl', function ($scope, $http) {

  $scope.mapAll = function() {
	  $http.get("parkData")
	  	.success(function(data){
	  		$scope.mapOfAllParks = data;
	  	});
  }

  $scope.mapAll();

});