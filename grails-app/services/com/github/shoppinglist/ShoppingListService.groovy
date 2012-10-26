package com.github.shoppinglist

import org.hibernate.FetchMode as FM
import groovy.json.JsonSlurper

class ShoppingListService{

	static transactional = false

	def saveShoppingList(requestJsonData){
		def jsonData = new JsonSlurper().parseText(requestJsonData)
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
	}	

	def findShoppingListByName(listName){
		def shoppingList = ShoppingList.findByName(listName)
		def responseData = shoppingList.properties.collectEntries{p->
			["${p.key}":p.value]
		} 
		responseData.id = shoppingList.id
		responseData.items = shoppingList.items
		responseData
	}

	def listShoppingListNames(){
		ShoppingList.createCriteria().list{
			projections{
				property "name"	
			}
		}
	}
}
