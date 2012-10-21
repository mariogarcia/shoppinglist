'use strict';

var module = angular.module('shoppingServices', []);

/**
 * This service manages the items inside the current list
 **/
module.factory('ItemService', function($http){
	var items = [];
 /* Methods implemented in this service */
	return {
	 /* Adds the item in the current list */
		add: function(item){
			items.push(item);
		},
	 /* Returns all items in the current list */
		list: function(){
			return items;
		},
	  /**
	    * Remove the given item from the current list.
	    * Removes by description so any matching item
	    * will be removed from the current list
	    **/
		remove: function(item){
			var len=items.length;
			var newList = [];
			for(var i=0; i<len; i++) {
				var next = items[i];
				console.log(next.description !== item.description);
				if (next.description != item.description){
					newList.push(next);
				}
			}
			items = newList;
		},
	 /* Deletes all items from current list */
		reset: function(){
			items = [];
			return items;
		},
		saveList: function(listName,callbackOK,callbackKO){
			var url = 'shoppingList/save';
			var data = 'data={"items":'+angular.toJson(items)+',"name":"'+listName+'"}';
			var headers = {headers:{'Content-Type':'application/x-www-form-urlencoded'}};
			$http.
				post(url,data,headers).
				success(callbackOK).
				error(callbackKO);
		},
		getListsNames: function(callback){
			$http.
				get('shoppingList/list').
			 /* Callbacks have to do more with views */
				success(callback).
				error(callback);
		},
		loadList: function(listName,callback){
			$http.
				get('shoppingList/show?name='+listName).
			 /* Callbacks have to do more with views */
				success(callback).
				error(callback);
		}
	}
});
