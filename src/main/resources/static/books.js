angular.module('myApp', []).controller(
		'booksCtrl',
		function($scope, $http) {
			$http.get('http://localhost:8080/app/book')
				.then(function(response) {
					//$scope.content = response.data;
					$scope.books = response.data.books;
				});
			$scope.title = "";
			$scope.author = "";
			$scope.year = "";
			$scope.info = "";
			$scope.edit = true;
			$scope.error = false;
			$scope.incomplete = false;
			$scope.hideform = true;

			$scope.editBook = function(id) {
				$scope.hideform = false;
				if (id == 'new') {
					$scope.edit = true;
					$scope.incomplete = true;
					$scope.id = '';
					$scope.title = '';
					$scope.author = '';
					$scope.year = '';
					$scope.info = '';
				} else {
					$scope.edit = true;
					$scope.title = $scope.books[id].title;
					$scope.author = $scope.books[id].author;
					$scope.year = $scope.books[id].year;
					$scope.info = $scope.books[id].info;
					$scope.id = $scope.books[id].id;
				}
			};

			$scope.saveBook = function() {

				$scope.obj  = {
					title :$scope.title,
					author : $scope.author,
					info : $scope.info,
					year : $scope.year,
					id : $scope.id
				};

				//msg = new String("?title="+$scope.title+"&"+"author="+$scope.author+"&"+"info="+$scope.info+"&"+ "year=" +$scope.year +"");

				$scope.hideform = true;

				if($scope.id=='')
					$http.post('http://localhost:8080/app/book',JSON.stringify( $scope.obj), {
						headers: {
							'Content-Type': 'application/json; charset=UTF-8'
						},
						'Accept': 'application/json'
					}).then(function onSuccess(data) {
						window.alert(JSON.stringify(data.data));
						$http.get('http://localhost:8080/app/book').then(
							function (response) {
								$scope.content = response.data;
								$scope.books = response.data.books;
							});
					}, function onError(err) {
						// do something on error
					});
				else
					$http.put('http://localhost:8080/app/book', JSON.stringify($scope.obj), {
						headers: {
							'Content-Type': 'application/json; charset=UTF-8'
						},
						'Accept': 'application/json'
					}).then(function onSuccess(data) {
						//$scope.tmp = Number($scope.year);
						window.alert(JSON.stringify(data.data));
						$http.get('http://localhost:8080/app/book').then(
							function (response) {
								$scope.content = response.data;
								$scope.books = response.data.books;
							});
					}, function onError(err) {
						$scope.tmp = "Error";
						// do something on error
					});
				$scope.id=''
			};

			$scope.$watch('id', function() {
				$scope.test();
			});
			$scope.$watch('title', function() {
				$scope.test();
			});
			$scope.$watch('author', function() {
				$scope.test();
			});
			$scope.$watch('year', function() {
				$scope.test();
			});
			$scope.$watch('info', function() {
				$scope.test();
			});

			$scope.test = function() {
				$scope.incomplete = false;
				if ($scope.edit && (!$scope.title.length || !$scope.author.length || !$scope.year.length )) {
					$scope.incomplete = true;
				}
			};
		});