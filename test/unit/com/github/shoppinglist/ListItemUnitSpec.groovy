package com.github.shoppinglist

import grails.test.mixin.*
import grails.test.mixin.support.*
import spock.lang.Specification
/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@Mock(ShoppingList)
@TestFor(ListItem)
class ListItemUnitSpec extends Specification{

	def "Saving a ListItem successfully"(){
		expect: "Trying to save it"
			!(new ListItem(description: description ,price: price ,units: units,shoppingList: list?.save()).
				save()) == willFail
		where: "We should be able to ast fot its id"
			description	|	price	|	units	|	  list			|  willFail	
				null	|	 23		|	  3		| validShoppingList	|   true	
			 "descrip"	|   null	|	  3		| validShoppingList	|	true
			 "descrip"	|    23		| 	 null	| validShoppingList	|	true
			 "descrip"	|    23		| 	  3		| 	   null			|	true
			 "descrip"	|    23		| 	  3		| validShoppingList	|  false
	}

 /* Just a method helper for getting a ShoppingList instance */
	def getValidShoppingList(){
		new ShoppingList(
			name: "list",
			description: "description"	
		)
	}
}
