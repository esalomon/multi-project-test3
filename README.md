# multi-project-test3
This project contains a Grails Application and and two Grails Plugin, the application is configured to use the plugins in inline mode. It was created using the Grails 3.2.11 version.

## Projects creation

1 The multi-project folder is created:

```
mkdir multi-project-test3
cd multi-project-test3
```

2 The Grails Application and the plugins are created:

```
grails create-app myApp
grails create-plugin myPlugin1
grails create-plugin myPlugin2
```

3 The myApp's settings.gradle file is deleted:
```
rm myApp/settings.gradle 
```

4 The multi-project's settings.gradle file is created with the next contents:
```
include 'myApp', 'myPlugin1', 'myPlugin2'
project(':myApp').name = 'myApp'
```

5 The myApp's build.gradle file is updated with the inline plugin references:
```
grails {
    plugins {
        compile project(":myPlugin1")
        compile project(":myPlugin2")
    }
}
```

## Project test
Three controllers are created, one in each Grails project in order to test the application:

1 The myApp's controller is created:
```
cd myApp
grails create-controller myAppController
```

2 The myApp's controller is updated with the next code:
```
package myapp

class AppController {

    def index() {
        render "[${new Date()}] This is the myApp's appController's index response."
    }
}
```

3 The myPlugin1's controller is created:
```
cd myPlugin1
grails create-controller myPlugin1Controller
```

4 The myPlugin1's controller is updated with the next code:
```
package myplugin1

class Plugin1Controller {

    def index() {
        render "[${new Date()}] This is the myPlugin1's plugin1Controller's index response."
    }
}
```

5 The myPlugin2's controller is created:
```
cd myPlugin2
grails create-controller myPlugin2Controller
```

6 The myPlugin2's controller is updated with the next code:
```
package myplugin2

class Plugin2Controller {

    def index() {
        render "[${new Date()}] This is the myPlugin2's plugin2Controller's index response."
    }
}
```

## Project execution
When the myApp project is executed with the run-app command, it displays the main Grails page with the three controllers, one from each Grails project:
```
cd myApp
grails run-app
| Running application...
Grails application running at http://localhost:8080 in environment: development
```