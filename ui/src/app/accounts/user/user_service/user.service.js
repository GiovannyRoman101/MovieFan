'use strict'

export default class userService {
  /* @ngInject */
  constructor ($http, apiUrl) {
    var service = this
    service.$http = $http
    service.apiUrl = apiUrl
  }
  getTheaters = function () {
    return this.$http.get(this.apiUrl + '/theaters').then(result => result.data)
  }
  getMovies = function (theatername) {
    return this.$http.get(this.apiUrl + '/theaters/' + theatername + '/movies').then(result => result.data)
  }
  getMovieRoom = function (theatername, moviename) {
    return this.$http.get(this.apiUrl + '/theaters/' + theatername + '/movies/' + moviename + '/rooms').then(result => result.data)
  }
  purchaseTicket = function (email, room) {
    return this.$http.put(this.apiUrl + '/users/' + email + '/tickets', room).then(result => result.data)
  }
  getUser = function (email) {
    return this.$http.get(this.apiUrl + '/users/' + email).then(result => result.data)
  }
}
