package myapp

class AppController {

    def index() {
        render "[${new Date()}] This is the myApp's appController's index response."
    }
}
