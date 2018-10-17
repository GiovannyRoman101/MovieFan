import apiUrl from './api.url.js'
import register from './register/register.module.js'
import mainpage from './mainpage/mainpage.module.js'
import login from './login/login.module.js'

export default
  angular
    .module('moviefan', ['ngAria',
      'ngAnimate',
      'ngMessages', 'ui.router', register,
      mainpage, login
    ])
    .constant('apiUrl', apiUrl)
    .name
