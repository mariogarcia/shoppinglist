modules = {
	angularTests{

		dependsOn 'jquery'
		dependsOn 'angular-scenario'

		resource url: 'css/bootstrap/bootstrap-responsive.css'
		resource url: 'css/bootstrap/bootstrap.css'
		resource url: 'css/mobile.css'

		resource url: 'js/lib/bootstrap/bootstrap.js'
		resource url: 'js/app/app.js'
		resource url: 'js/app/controllers.js'
		resource url: 'js/app/services.js'
		resource url: 'js/tests/e2e/scenarios.js'
	}
}
