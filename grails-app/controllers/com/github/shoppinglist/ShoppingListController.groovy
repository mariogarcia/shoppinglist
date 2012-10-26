package com.github.shoppinglist

import grails.converters.JSON

/**
 * This controller does the backup and recovery of the shopping lists
**/
class ShoppingListController {

	def shoppingListService

 /* Saving the list and its item received inside a json string */
    def save() { 
		render shoppingListService.saveShoppingList(params.data) as JSON		
	}
 /* Looking for a given shopping list by its name */
	def show() {
		render shoppingListService.findShoppingListByName(params.name) as JSON
	}
 /* Looking for the names of the stored lists */
	def list(){
		render shoppingListService.listShoppingListNames() as JSON
	}
}
