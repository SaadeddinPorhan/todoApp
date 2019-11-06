package todoApp.enduser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EnduserController {
	
	@Autowired
	private EnduserService enduserService;
	
	@RequestMapping("/users")
	public List<Enduser> getAllEndusers() {
		return enduserService.getAllEndusers();
	}
	
	@RequestMapping("/users/{id}")
	public Enduser getEnduser(@PathVariable Long id) {
		return enduserService.getEnduser(id);
	}
	
	@RequestMapping("/users/{id}/{username}")
    public Enduser getEnduserByuserNameEnduser(@PathVariable String username) {
    	return enduserService.getEnduserByUserName(username);
    }
	
	@RequestMapping (method=RequestMethod.POST,value="/users")
	public void addEnduser (@RequestBody Enduser enduser) {
		enduserService.addEnduser(enduser);	
	}
	
	@RequestMapping (method=RequestMethod.PUT,value="/users/{id}")
	public void updateEnduser (@RequestBody Enduser enduser,@PathVariable Long id) {
		enduserService.updateEnduser(id,enduser);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	public void deleteEnduser(@PathVariable Long id) {
		enduserService.deleteEnduser(id);
	}
}
