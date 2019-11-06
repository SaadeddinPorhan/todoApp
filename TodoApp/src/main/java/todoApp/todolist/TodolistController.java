package todoApp.todolist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import todoApp.enduser.Enduser;

@CrossOrigin
@RestController
public class TodolistController {

	@Autowired
	private TodolistService todolistService;
	
	@RequestMapping("/users/{id}/todolists")
	public List<Todolist> getAllTodoLists(@PathVariable Long id) {
		return todolistService.getAllTodoLists(id);
	}
	
	@RequestMapping("/users/{userId}/todolists/{id}")
	public Todolist getTodoList(@PathVariable Long id) {
		return todolistService.getTodoList(id);
	}
	
	@RequestMapping("/users/{userId}/todolists/{id}/{name}")
	public Todolist getTodoListByName(@PathVariable String name) {
		return todolistService.getTodoListByName(name);
	}
	
	@RequestMapping (method=RequestMethod.POST,value="/users/{userId}/todolists")
	public void addTodoList (@RequestBody Todolist todolist,@PathVariable Long userId) {
		todolist.setEnduser(new Enduser(userId,"",""));
		todolistService.addTodoList(todolist);
	}
	
	@RequestMapping (method=RequestMethod.PUT,value="/users/{userId}/todolists/{id}")
	public void updateTodoList (@RequestBody Todolist todolist,@PathVariable Long userId,@PathVariable Long id) {
		todolist.setEnduser(new Enduser(userId,"",""));
		todolistService.updateTodoList(todolist);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{userId}/todolists/{id}")
	public void deleteTodoList(@PathVariable Long id) {
		todolistService.deleteTodoList(id);
	}
}
