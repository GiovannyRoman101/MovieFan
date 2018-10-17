'use strict'
var bcrypt = require('bcryptjs')

export default class LoginController {
  /* @ngInject */
  constructor (loginService, $state) {
    var ctrl = this
    ctrl.user
    ctrl.login = function (user) {
      loginService.login(user.email).then(function (data) {
        bcrypt.compare(user.password, data.password, function (err, res) {
          if (res === true) {
            if (data.type === 'USER') {
              $state.go('user', {email: data.email})
            } else if (data.type === 'ADMIN') {
              $state.go('admin', {email: data.email})
            }
          }
        })
      })
    }
  }

}
