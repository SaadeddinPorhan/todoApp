package todoApp.item;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import todoApp.enduser.Enduser;
import todoApp.todolist.Todolist;

@CrossOrigin

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/users/{userId}/todolists/{id}/items")
	public List<Item> getAllItems(@PathVariable Long id) {
		return itemService.getAllItems(id);
	}
	
	@RequestMapping("/users/{userId}/todolists/{todoListId}/items/{id}")
	public Item getItem(@PathVariable Long id) {
		return itemService.getItem(id);
	}
	
	@RequestMapping (method=RequestMethod.POST,value="/users/{userId}/todolists/{todoListId}/items")
	public void addItem (@RequestBody Item item,@PathVariable Long userId,@PathVariable Long todoListId) {
		Todolist tList = new Todolist(todoListId,"",null,"");
		tList.setEnduser(new Enduser(userId,"",""));
		item.setTodolist(tList);
		itemService.addItem(item);	
	}
	
	@RequestMapping (method=RequestMethod.PUT,value="/users/{userId}/todolists/{todoListId}/items/{id}")
	public void updateItem (@RequestBody Item item,@PathVariable Long userId,@PathVariable Long todoListId,@PathVariable Long id) {
		Item updateditem;
		updateditem=itemService.getItem(id);
		updateditem.setStatus(true);
		Todolist tList = new Todolist(todoListId,"",null,"");
		tList.setEnduser(new Enduser(userId,"",""));
		updateditem.setTodolist(tList);
		itemService.addItem(updateditem);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{userId}/todolists/{todoListId}/items/{id}")
	public void deleteCourse(@PathVariable Long id) {
		itemService.deleteItem(id);
	}
}
