package myplugin1

class Plugin1Controller {

    def index() {
        render "[${new Date()}] This is the myPlugin1's plugin1Controller's index response."
    }
}
