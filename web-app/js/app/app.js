'use strict';

angular.module('shoppinglist', ['shoppingServices']).
  	config(['$routeProvider', function($routeProvider) {$routeProvider.
	 /* MAIN MENU */
		when('/index', {templateUrl: 'partials/main-menu.html',   controller: MainMenuController}).
	 /* BLANK LIST */
		when('/new-list',{templateUrl: 'partials/new-list.html',controller:NewListController}).
	 /* EDIT CURRENT LIST */
		when('/edit-list',{templateUrl: 'partials/new-list.html',controller:EditListController}).
	 /* SAVING FORM */
		when('/save-list',{templateUrl: 'partials/save-list.html',controller:SaveListController}).
	 /* ADD NEW ITEM FORM */
		when('/add-item',{templateUrl: 'partials/add-item.html',controller:AddNewItem}).
	 /* AVAILABLE LISTS */
		when('/shopping-lists',{templateUrl: 'partials/shopping-lists.html',controller:LoadListController}).
	 /* OTHERWISE */
		otherwise({redirectTo: '/index'});
}]);
