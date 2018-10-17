'use strict'
var moment = require('moment')
export default class UserController {

  /* @ngInject */
  constructor (userService, $state, $scope, $stateParams) {
    var ctrl = this
    ctrl.movies
    ctrl.tickets
    ctrl.theaters
    ctrl.user

    const today = moment().format('MMM Do YYYY')

    ctrl.date = today

    ctrl.getTheaters = function () {
      userService.getTheaters().then(data => {
        ctrl.theaters = data
        ctrl.theaters.forEach(theater => {
          userService.getMovies(theater.name).then(data => {
            theater.movies = data
            theater.movies.forEach(movie => {
              userService.getMovieRoom(theater.name, movie.name).then(data => {
                movie.rooms = data
              })
            })
          })
        })
      })
    }

    ctrl.getUser = function (email) {
      userService.getUser(email).then(result => {
        ctrl.user = result
        console.log(ctrl.user)
      })
    }

    ctrl.purchaseTicket = function (room) {
      console.log(ctrl.user)
      if (ctrl.user !== null) {
        userService.purchaseTicket(ctrl.user.email, room).then(data => {
          ctrl.getUser(ctrl.user.email)
        })
      } else {
        $state.go('home')
      }
    }

    $scope.userRefresh = function () {
      ctrl.getTheaters()
      ctrl.getUser($stateParams.email)
    }
    $scope.userRefresh()
  }
}
