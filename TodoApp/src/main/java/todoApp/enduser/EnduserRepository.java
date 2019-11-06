package todoApp.enduser;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import todoApp.item.Item;

public interface EnduserRepository extends CrudRepository<Enduser,Long>{
	public Enduser findByuserName(String username);

}
