'use strict'

export default class RegisterService {
  /* @ngInject */
  constructor ($http, apiUrl) {
    var service = this
    service.$http = $http
    service.apiUrl = apiUrl
  }
  createUser = function (user) {
    return this.$http.post(this.apiUrl + '/users', user).then(result => result.data)
  }
}
