var roleModule = angular.module('roleModule', []);

roleModule.controller("roleController", function($scope,$http) {
	url = 'http://localhost:8080/Seguranca/rs/role';	
	urlSistema = 'http://localhost:8080/Seguranca/rs/sistema';
	
	$scope.pesquisarSistemas = function() {
		$http.get(urlSistema).success(function (sistemas) {
			$scope.sistemas = sistemas;
		}).error(function (erro) {
			alert(erro);
		});
	};
		
	$scope.pesquisar = function() {
		$http.get(url).success(function (roles) {
			$scope.roles = roles;
		}).error(function (erro) {
			alert(erro);
		});
	};	
	
	$scope.novo = function() {
		$scope.role = "";	
		$scope.sistemaRSelecionado = "";
		$scope.sistemasRs = [];
		$scope.desabilitaSalvar = false;
	};
	
	$scope.seleciona = function(role) {
		$scope.role = role;
		$scope.desabilitaSalvar = true;
		$scope.sistemas = [];
		$scope.sistemas.push($scope.role.sistema);
		for (posicao in $scope.sistemas) {
			sistema = $scope.sistemas[posicao];
			for (posicao1 in sistema.sistemas) {
				sistema = sistema.sistemas[posicao1];
				if (sistema.url == $scope.role.sistema.url) {
					$scope.sistemaSelecionado = sistema;
				}				
			}			
		}		
	};
	
	$scope.alterarUrlRegisto = function() {
		$scope.sistemasRs = $scope.sistemaRSelecionado.sistemas;		
	};
	
	
	$scope.selecionaSistemaView = function(remetente) {
		$scope.role.remetente = remetente;
	};
	
		
	$scope.salvar = function() {
		$http.post(url,$scope.role)
		.success(function (role) {
		$scope.roles.push(role);
		$scope.novo();
		}).error(function (erro) {
			alert(erro);
		});	
	};
	
	$scope.pesquisar();
	$scope.pesquisarSistemas();
			
		
	});