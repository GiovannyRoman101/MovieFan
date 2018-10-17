'use strict'

export default class AdminController {
  /* @ngInject */
  constructor (adminService, $state, $scope) {
    var ctrl = this
    ctrl.user
    ctrl.movies
    ctrl.theaters

    ctrl.getMovies = function () {
      adminService.getMovies().then(data => {
        if (ctrl.movies !== data) {
          ctrl.movies = data
        }
      })
    }

    ctrl.createMovie = function (movie) {
      adminService.createMovie(movie).then(data => {
        ctrl.getMovies()
      })
    }

    ctrl.getTheaters = function () {
      adminService.getTheaters().then(data => {
        if (ctrl.theaters !== data) {
          ctrl.theaters = data
        }
      })
    }

    ctrl.createTheater = function (theater) {
      adminService.createTheater(theater).then(data => {
        console.log(data)
        ctrl.getTheaters()
      })
    }

    ctrl.createRoom = function (room) {
      adminService.createRoom(room).then(data => {
        // TODO: display a message to ensure room was created
      })
    }

    $scope.update = function () {
      ctrl.getTheaters()
      ctrl.getMovies()
    }
    $scope.update()
  }
}
