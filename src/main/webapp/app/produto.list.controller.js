(function(){
  'use strict'

  angular.module('app')
    .controller('ProdutoListController', ProdutoListController);
  
  ProdutoListController.$inject = ['ProdutoService']
  
  function ProdutoListController(ProdutoService) {
      var vm = this;
      vm.registros = [];
  
      function load() {
          ProdutoService.findAll()
            .then(function (dados) {
                vm.registros = dados
            });
      }
  
      load();
  }
})();

