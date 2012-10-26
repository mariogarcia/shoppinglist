package com.github.shoppinglist

import groovy.json.JsonSlurper
import grails.test.mixin.*
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock([ShoppingList,ListItem])
@TestFor(ShoppingListController)
class ShoppingListControllerUnitSpec extends Specification{

	def setup(){
		controller.shoppingListService = new ShoppingListService()
	}

	def "Testing save action successfully"(){
		setup: "Creating some jsonData to pass as parameter"
			def jsonData = '''{
				"items":[{"description":"desc","price":22,"units":2}],
				"name": "name"
			}'''
		when: "Passing the json data to the controller and invoking 'save'"
			controller.params.data = jsonData
			controller.save()
		and: "Getting the response as string"
			def jsonResponse = new JsonSlurper().parseText(response.contentAsString)
		then: "The controller will answer with a json response"
			jsonResponse
			jsonResponse.status == 'SUCCESS'
	}

	def "Testing show action successfully"(){
		setup: "Saving a shopping list"
			def item = validListItem
			def savedShoppingList = validShoppingList.
				addToItems(item).
			save()
		and: "Saving the shopping list items"
			item.save()	
		when: "Passing the name of the list as the parameter"
			controller.params.name = savedShoppingList.name
			controller.show()
		and: "Getting the response as JSON"
			def jsonResponse = new JsonSlurper().parseText(response.contentAsString)
		then: "We should be able to recover the list and its items"
			jsonResponse.name == "myList"
			jsonResponse.description == "myList"
			jsonResponse.items.size() == 1
	}

	def "Testing list action successfully"(){
		setup: "Saving a shopping list"
			def item = validListItem
			def savedShoppingList = validShoppingList.
				addToItems(item).
			save()
		and: "Saving the shopping list items"
			item.save()
		when: "Invoking the list action"
			controller.list()
			def jsonResponse = new JsonSlurper().parseText(response.contentAsString)
		then: "The response should return the names of the available lists"
			jsonResponse.size() == 1
			jsonResponse[0] == "myList"	
	}

 /* Returns a valid instance of ShoppingList */
	def getValidShoppingList(){
		new ShoppingList(
			name: "myList",
			description: "myList"
		)
	}

 /* Returns a valid instance of ListItem */
	def getValidListItem(){
		new ListItem(
			description: "item",
			price:22,
			units:2
		)
	}

}
