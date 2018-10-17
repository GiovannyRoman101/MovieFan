import registerApp from './register.component.js'
import registerService from './register_service/register.service.js'

export default
  angular
    .module('registerApp', [])
    .component('registerApp', registerApp)
    .service('registerService', registerService)
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
      $urlRouterProvider.otherwise('/')
      $stateProvider
        .state('register', {
          url: '/register',
          component: 'registerApp'
        })
    }])
    .name
