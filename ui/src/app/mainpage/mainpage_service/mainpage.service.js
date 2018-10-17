'user strict'

export default class MainpageService {
  /* @ngInject */
  constructor ($http, apiUrl) {
    var service = this
    service.$http = $http
  }

}
