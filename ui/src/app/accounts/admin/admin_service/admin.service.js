'use strict'

export default class adminService {
  /* @ngInject */
  constructor ($http, apiUrl) {
    var service = this
    service.$http = $http
    service.apiUrl = apiUrl
  }
  createMovie = function (movie) {
    return this.$http.post(this.apiUrl + '/movies', movie).then(result => result.data)
  }
  createTheater = function (theater) {
    return this.$http.post(this.apiUrl + '/theaters', theater).then(result => result.data)
  }
  getTheaters = function () {
    return this.$http.get(this.apiUrl + '/theaters').then(result => result.data)
  }
  getMovies = function () {
    return this.$http.get(this.apiUrl + '/movies').then(result => result.data)
  }
  createRoom = function (room) {
    return this.$http.post(this.apiUrl + '/rooms', room).then(result => result.data)
  }
}
