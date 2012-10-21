modules = {
    application {
        resource url:'js/lib/application.js'
    }
	mobile {
		dependsOn 'jquery'

	 /* Stylesheets */
		resource url: 'css/bootstrap/bootstrap-responsive.css'
		resource url: 'css/bootstrap/bootstrap.css'
		resource url: 'css/mobile.css'

	 /* Third party's libraries */
		resource url: 'js/lib/bootstrap/bootstrap.js'
		resource url: 'js/lib/angularjs/angular.js'
		resource url: 'js/lib/angularjs/angular-sanitize.js'
	 /* Application's libraries */
		resource url: 'js/app/app.js'
		resource url: 'js/app/controllers.js'
		resource url: 'js/app/services.js'
	}
}
