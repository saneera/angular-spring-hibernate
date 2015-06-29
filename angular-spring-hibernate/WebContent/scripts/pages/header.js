function LocationController($scope, $location) {
    if($location.$$absUrl.lastIndexOf('/contacts') > 0){
        $scope.activeURL = 'contacts';
    } else if($location.$$absUrl.lastIndexOf('/users') > 0){
        $scope.activeURL = 'users';
    } else if($location.$$absUrl.lastIndexOf('/test') > 0){
        $scope.activeURL = 'test';
    } else{
        $scope.activeURL = 'home';
    }
}