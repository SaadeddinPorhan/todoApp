package todoApp.todolist;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TodolistRepository extends CrudRepository<Todolist, Long>{
	
	public List<Todolist> findByEnduserId(Long userId);
	public Todolist findByName(String name);

}
