package com.github.shoppinglist

import org.hibernate.FetchMode as FM
import grails.converters.JSON
import groovy.json.JsonSlurper

class ShoppingListController {

    def save() { 
		def jsonData = new JsonSlurper().parseText(params.data)
		def listItems = jsonData.items.collect{item->
			[description:item.description,price:item.price,units:item.units] as ListItem
		}
		def shoppingList = 
			new ShoppingList(name:jsonData.name,description:jsonData.name).save()
		listItems.each{
			shoppingList.addToItems(it).save()
		}
		def failure = shoppingList.hasErrors()
		def restResponse = [status: (failure ? 'FAILURE' : 'SUCCESS'), cause: failure ? shoppingList.errors.toString() : ""]

		render restResponse as JSON		
	}

	def show() {
		def listName = params.name
		def shoppingList = ShoppingList.findByName(listName)
		def responseData = shoppingList.properties.collectEntries{p->
			["${p.key}":p.value]
		} 
		responseData.items = shoppingList.items
		render responseData as JSON
	}

	def list(){
		def listNames = ShoppingList.createCriteria().list{
			projections{
				property "name"	
			}
		}
		
		render listNames as JSON
	}
}
