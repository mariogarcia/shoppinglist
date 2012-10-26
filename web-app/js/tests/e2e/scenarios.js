
describe("Loading the main menu and create a new list", function() {

	it("Loading main menu", function() {
		browser().navigateTo("/shoppinglist");
	 /* In the main menu we should have 3 buttons but
	  * only 2 should be shown */
		expect(element('button').count()).toEqual(3);
		expect(element('button:visible').count()).toEqual(2);
	});

	it("Creating an empty list", function() {
	 /* Clicking on new list */
		browser().navigateTo("/shoppinglist");
		element('button:first').click();
	 /* In the list view we should see the home, add and save icons */	
		expect(element('i').count()).toEqual(3);	
		expect(element('i.icon-home').count()).toEqual(1);	
		expect(element('i.icon-hdd').count()).toEqual(1);		
		expect(element('i.icon-plus-sign').count()).toEqual(1);	
	});
});
