package todoApp.todolist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoApp.item.Item;
import todoApp.item.ItemService;


@Service
public class TodolistService {

	@Autowired
	private TodolistRepository todolistRepository;
	
	public List<Todolist> getAllTodoLists(Long userId){

		List<Todolist> todolists = new ArrayList<>();
		todolistRepository.findByEnduserId(userId).forEach(todolists::add);
		return todolists;
		
	}
	
	public Todolist getTodoList(Long id) {
		return todolistRepository.findById(id).get();
	}
	
	public Todolist getTodoListByName(String name) {
		return todolistRepository.findByName(name);
	}

	public void addTodoList(Todolist todolist) {
		todolistRepository.save(todolist);
	}

	public void updateTodoList(Todolist todolist) {
		todolistRepository.save(todolist);

	}

	public void deleteTodoList(Long id) {
		todolistRepository.deleteById(id);
		
	}
	

}
