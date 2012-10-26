package com.github.shoppinglist

import grails.plugin.spock.IntegrationSpec

class ShoppingListServiceIntegrationSpec extends IntegrationSpec{

	def shoppingListService

	def "Saving a given shopping list"(){
		given: "A json string with the shopping list"
			def jsonData = '''{
				"items":[{"description":"desc","price":22,"units":2}],
				"name": "name"
			}'''
		when: "Saving the list"
			def responseMap = shoppingListService.saveShoppingList(jsonData)	
		then: "It should return a map telling us whether if the list has been saved or not"
			responseMap.status == "SUCCESS"
			!responseMap.errors
	}

	def "Loading a shopping list by name"(){
		setup: "Building some data first"
			def shoppingList = getValidShoppingList()
			def item = getValidListItem()
		when: "Saving the data"
			shoppingList.addToItems(item).save()
			item.save()
		and: "Trying to recover it later on"
			def retrievedList = shoppingListService.findShoppingListByName("myList")
		then:"We should be able to do it"
			retrievedList
			retrievedList.id == shoppingList.id
			retrievedList.items.size() == 1
			retrievedList.items.find{it}.id == item.id
	}

	def "Getting all list names"(){
		setup: "Building some data"
			def shoppingList = getValidShoppingList()
			def item = getValidListItem()
		and: "Saving the data"
			shoppingList.addToItems(item).save()
			item.save()
		when: "Looking for the different list names"
			def names = shoppingListService.listShoppingListNames()
		then: "We should receive a list only with the names"
			names
			names.size() == 1
			names == ['myList']
	}

	def getValidShoppingList(){
		new ShoppingList(
			name: "myList",
			description: "description"
		)
	}

	def getValidListItem(){
		new ListItem(
			description: "product",
			price: 22.2,
			units: 2
		)
	}
}
