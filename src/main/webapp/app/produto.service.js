(function(){
    'use strict'

    angular.module('app')
      .service('ProdutoService', ProdutoService);

    ProdutoService.$inject = ['$http'];

    function ProdutoService($http) {

        function findAll(filtro) {
            return $http.get('http://localhost:8090/api/produtos?filtro=' + filtro)
              .then(function(response) {
                return response.data;
              });
        }

        function insert(registro) {
            return $http.post('http://localhost:8090/api/produtos', registro)
              .then(function (response) {
                  return response.data;
              });
        }

        return {
            findAll: findAll,
            insert: insert
        }

    }

})();