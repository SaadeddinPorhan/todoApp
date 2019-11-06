package todoApp.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> getAllItems(Long todoListId){

		List<Item> items = new ArrayList<>();
		itemRepository.findByTodolistId(todoListId).forEach(items::add);
		return items;
		
	}
	
	public Item getItem(Long id) {
		return itemRepository.findById(id).get();
	}
	
	public void addItem(Item item) {
		itemRepository.save(item);
	}
	
	public void updateItem(Item item) {
		itemRepository.save(item);

	}
	public void deleteItem(Long id) {
		itemRepository.deleteById(id);
		
	}
}
