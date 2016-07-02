var app = angular.module('sistemaModule',[]);

app.controller('sistemaControl',function($scope,$http){	
	var url = 'http://localhost:8080/Seguranca/rs/sistema';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (sistemasRetorno) {
			$scope.sistemas = sistemasRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.sistema = {};
	}

    $scope.salvar = function() {
		if ($scope.sistema.codigo == '') {
			$http.post(url,$scope.sistema).success(function(sistema) {
				$scope.sistemas.push($scope.sistema);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.sistema).success(function(sistema) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.sistema.codigo == '') {
			alert('Selecione um sistema');
		} else {
			urlExcluir = url+'/'+$scope.sistema.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(sistemaTabela) {
		$scope.sistema = sistemaTabela;
	}
});