import loginApp from './login.component.js'
import loginService from './login_service/login.service.js'
import user from '../accounts/user/user.module.js'
import admin from '../accounts/admin/admin.module.js'

export default
  angular
    .module('loginApp', [user, admin])
    .component('loginApp', loginApp)
    .service('loginService', loginService)
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
      $urlRouterProvider.otherwise('/')
      $stateProvider
        .state('login', {
          url: '/login',
          component: 'loginApp'
        })
    }])
    .name
