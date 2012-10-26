modules = {
	unitTests{
		defaultBundle 'testing-dependencies'

		dependsOn 'jquery'
		dependsOn 'jasmine'
		dependsOn 'angular'

		resource url: 'js/lib/angular/angular-mocks.js'

		resource url: 'js/app/app.js'
		resource url: 'js/app/controllers.js'
		resource url: 'js/app/services.js'

		resource url: 'js/tests/unit/controllerSpec.js'
		resource url: 'js/tests/unit/serviceSpec.js'
	}
}
