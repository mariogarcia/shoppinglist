package com.github.shoppinglist

class ShoppingList {

	String name
	String description 

	static hasMany = [items:ListItem]

    static constraints = {
		name nullable:false,blank:false
		description nullable:false,blank:false
    }
	static mapping = {
		items lazy:false
	}
}
