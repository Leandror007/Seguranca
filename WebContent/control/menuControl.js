var app = angular.module('menuModule',[]);

app.controller('menuController',function($scope,$http,$window){
	
	var url = 'http://localhost:8080/Seguranca/rs/sistema/usuarioLogado';
		
	var urlLogout = 'http://localhost:8080/Seguranca/rs/logout';
	
	
	$scope.sistemas = [{"url":"http://localhost:8080/SistemaEcommerce","nome":"Sistema Ecommerce"},
                      {"url":"http://localhost:8080/Clinica/menu.html","nome":"Menu Clinica"},
                      {"url":"http://localhost:8080/Seguranca/seguranca.html","nome":"Menu Seguranca"}];
	

	$scope.pesquisar = function(){
		$http.get(url).success(function (sistemasRetorno) {
			$scope.sistemas = sistemasRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.logout = function() {
		$http.get(urlLogout).success(function () {		
			$window.location.href = '/Seguranca';
			$window.redirect();
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	
		
});