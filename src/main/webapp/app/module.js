(function(){

    angular.module('app', [
        'ui.router'
    ]);

    angular.module('app').config(AppConfig);

    AppConfig.$inject = ['$stateProvider'];

    function AppConfig($stateProvider) {

        $stateProvider
            .state({
                name: 'produtosList',
                url: '/produtos',
                templateUrl: '/view/produtos/list.html',
                controller: 'ProdutoListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'produtosNovo',
                url: '/produtos/novo',
                templateUrl: '/view/produtos/form.html',
                controller: 'ProdutoFormController',
                controllerAs: 'vm'
            });

    }

})();
