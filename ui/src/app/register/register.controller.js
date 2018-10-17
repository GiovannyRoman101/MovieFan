'user strict'
var bcrypt = require('bcryptjs')
export default class RegisterController {
  /* @ngInject */
  constructor (registerService, $state) {
    var ctrl = this

    ctrl.createUser = function (user) {
      bcrypt.genSalt(10, function (err, salt) {
        bcrypt.hash(user.password, salt, function (err, hash) {
          user.password = hash
          registerService.createUser(user).then(function (data) {
          })
          $state.go('home')
        })
      })
    }
  }

}
