package com.github.shoppinglist

import grails.test.mixin.*
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ShoppingList)
class ShoppingListUnitSpec extends Specification{

	def "Saving a ShoppingList successfully"(){
		expect:
			!(new ShoppingList(name:name,description:description).save()) == fail
		where:
			name	|	description	   |	fail
		   "list"	|	"my list"	   |	false
			null	|	"my list"	   |	true
		   "list"	|	 null		   |	true
	}

}
