package todoApp.enduser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnduserService {

	@Autowired
	private EnduserRepository enduserRepository;
	
	
	public List<Enduser> getAllEndusers(){

		List<Enduser> endusers = new ArrayList<>();
		enduserRepository.findAll().forEach(endusers::add);
		return endusers;
		
	}
	
	public Enduser getEnduser(Long id) {
		return enduserRepository.findById(id).get();
	}
	
	public Enduser getEnduserByUserName(String username) {
		return enduserRepository.findByuserName(username);
	}

	public void addEnduser(Enduser enduser) {
		enduserRepository.save(enduser);
	}

	public void updateEnduser(Long id, Enduser enduser) {
		enduserRepository.save(enduser);

	}

	public void deleteEnduser(Long id) {
		enduserRepository.deleteById(id);
		
	}
	

}
