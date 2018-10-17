import userApp from './user.component.js'
import userService from './user_service/user.service.js'

export default
  angular
    .module('userApp', [])
    .component('userApp', userApp)
    .service('userService', userService)
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
      $urlRouterProvider.otherwise('/')
      $stateProvider
        .state('user', {
          url: '/user/:email',
          component: 'userApp'
        })
    }])
    .name
