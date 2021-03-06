
describe('Testing how items are managed by the ItemService', function(){

	var itemService;

	beforeEach(module('shoppingServices'));
 /* Injecting some needed properties */
	beforeEach(inject(function($injector){
		itemService = $injector.get("ItemService");
	}));

	it('Adding elements',function() {
	 /* Scope la variable is an array containing [1,2] */
		itemService.add({
			"description":"Dish Washer",
			"units":2,
			"price":2.2	
		});
		expect(itemService.list().length).toBe(1); 
	});

	it('Removing all elements',function() {
	 /* Scope la variable is an array containing [1,2] */
		itemService.add({
			"description":"Dish Washer",
			"units":2,
			"price":2.2	
		});
		expect(itemService.list().length).toBe(1); 
		itemService.reset();
		expect(itemService.list().length).toBe(0); 
	});
	it('Removing just one item',function(){
		var item = {
			"description":"Dish Washer",
			"units":2,
			"price":2.2	
		};
		itemService.add(item);	
		expect(itemService.list().length).toBe(1); 
		itemService.remove(item);
		expect(itemService.list().length).toBe(0); 
	});
});
