package com.github.shoppinglist

class ListItem {

	static belongsTo = [shoppingList:ShoppingList]

	ShoppingList shoppingList

	String description
	Double price 
	Integer units

    static constraints = {
    }
}
