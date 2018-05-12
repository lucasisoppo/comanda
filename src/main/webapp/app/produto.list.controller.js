(function(){
  'use strict'

  angular.module('app')
    .controller('ProdutoListController', ProdutoListController);
  
  ProdutoListController.$inject = ['ProdutoService']
  
  function ProdutoListController(ProdutoService) {
      var vm = this;
      vm.registros = [];
      vm.filtro = '';

      vm.atualizar = load;

      function load() {
          ProdutoService.findAll(vm.filtro)
            .then(function (dados) {
                vm.registros = dados
            });
      }
  
      load();
  }
})();

