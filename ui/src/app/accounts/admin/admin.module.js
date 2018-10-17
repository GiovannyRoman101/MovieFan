import adminApp from './admin.component.js'
import adminService from './admin_service/admin.service.js'

export default
  angular
    .module('adminApp', [])
    .component('adminApp', adminApp)
    .service('adminService', adminService)
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
      $urlRouterProvider.otherwise('/')
      $stateProvider
        .state('admin', {
          url: '/admin/:email',
          component: 'adminApp'
        })
    }])
    .name
