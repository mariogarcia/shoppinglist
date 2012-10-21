'use strict';

/**
 * This controller handles the main menu actions
 *
 **/
function MainMenuController($scope,$location,ItemService){
 /* In order to show some of the menu options we
  * want to know if there's any item in the current list */
	$scope.items = ItemService.list();
 /* Creates a new list from scratch */	
	$scope.createNewList = function(){
		ItemService.reset();
		$location.path("new-list");
	}
 /* Loads the items of the list with the given name */
	$scope.loadStoredList = function(){
		$location.path("shopping-lists");
	}
}

/**
 * This controller handles the actions to get the lists.
 **/
function LoadListController($scope,$route,$location,ItemService){
 /* Once the page has been loaded it goes for the available lists */
	ItemService.getListsNames(function(data){
		$scope.names = data;		
	});  
 /* This action loads the items of a given list in the current list */	
	$scope.loadList = function(listName){
		ItemService.loadList(listName,function(data){
			ItemService.reset();
			var items = data.items
			var len = items.length
			for (var i = 0;i<len;i++){
				ItemService.add(items[i]);
			}
			$location.path("new-list");		
		},function(){});
	}
}
/**
 * Once the page is loaded we load the items 
 *
 **/
function NewListController($scope,$route,$location,ItemService){ 
	$scope.items = ItemService.list(); 
}

/**
 * This controller handles actions related to items in the list
 *
 **/
function ItemsController($scope,$route,$location,ItemService){
 /* If we click over the X then the item is removed from the current list */
	$scope.remove = function(item){
		ItemService.remove(item);
		$route.reload();
	}
}

/**
 *
 *
 **/
function EditListController($scope,ItemService){
	$scope.items = ItemService.list();	
}

/**
 * This controller handles the template where the user
 * can insert one more item to the list
 *
 **/
function AddNewItem($scope,$location,ItemService){
 /* Adding one more unit */
	$scope.plusOne = function(item){
		item.units = parseInt(item.units) + 1;
	}
 /* Minus one unit */
	$scope.minusOne = function(item){
		item.units = parseInt(item.units) - 1;
	}
 /* Adding the item to the basket */
	$scope.addToBasket = function(item){
		ItemService.add({
			"description": item.description,
			"units":item.units,
			"price":item.price
		});
		$location.path("edit-list");
	}
 /* Back to the list */
	$scope.cancel = function(){
		$location.path("edit-list");
	}
}

/**
 * This controller handles the action of saving the current
 * list.
 *
 **/
function SaveListController($scope,$location,ItemService){
 /* If we don´t want to save it */
	$scope.cancel = function(){
		$location.path("edit-list");
	}
 /* Saving the current list */
	$scope.save = function(listName){
		ItemService.saveList(
			listName,
			function(data, status, headers, config) {
				console.log(data);
				$location.path("edit-list");
			},
			function(data, status, headers, config) {
				console.log("error");
			});
	}
}
