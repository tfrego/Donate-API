package capstone.donate_api;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capstone.donate_api.models.Offer;
import capstone.donate_api.models.Request;
import capstone.donate_api.models.User;
import capstone.donate_api.repositories.RequestsRepository;
import capstone.donate_api.repositories.UsersRepository;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private RequestsRepository requestsRepository;
	
	@GetMapping("/")
	public List<User> getAllUsers() {
		return repository.findAll();
	}
	
	@GetMapping("/{uid}")
	public User getUserById(@PathVariable("uid") String uid) {
		return repository.findByUid(uid);
	}
	
	@PutMapping("/{id}")
	public void modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody User user) {
		user.setId(id);
		repository.save(user);
	}
	
	@PostMapping("/")
	public User createUser(@Valid @RequestBody User user) {
		user.setId(ObjectId.get());
		repository.save(user);
		return user;
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable ObjectId id) {
		repository.delete(repository.findById(id));;
	}
	
	@GetMapping("/requests/")
	public List<User> getAllUserRequests() {
		List<User> allUsers = repository.findAll();
		
		for (User user : allUsers) {
			String userId = user.uid;
			List<Request> userRequests = this.requestsRepository.findByUserIdAndStatus(userId, "active");
			user.setRequests(userRequests);
		}
		
		return allUsers;
	}
	
}