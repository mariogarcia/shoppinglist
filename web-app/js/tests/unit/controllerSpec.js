
describe('Testing controller',function(){

	var _$scope;
	var _$location;
	var _$controller;
	var _$http;
	var itemService;

	beforeEach(module('shoppingServices'));
 /* Injecting some needed properties */
	beforeEach(inject(function($rootScope,$location,$controller,$injector){
		_$scope = $rootScope;
		_$location = $location;
		_$controller = $controller;
		itemService = $injector.get("ItemService");
	}));

	it('Creating a new list',function(){
		expect(0).toBe(0);
	});


});
