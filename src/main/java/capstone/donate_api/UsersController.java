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

import capstone.donate_api.models.Users;
import capstone.donate_api.repositories.UsersRepository;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersRepository repository;
	
	@GetMapping("/")
	public List<Users> getAllUsers() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Users getUserById(@PathVariable("id") ObjectId id) {
		return repository.findById(id);
	}
	
	@PutMapping("/{id}")
	public void modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody Users users) {
		users.setId(id);
		repository.save(users);
	}
	
	@PostMapping("/")
	public Users createUser(@Valid @RequestBody Users users) {
		users.setId(ObjectId.get());
		repository.save(users);
		return users;
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable ObjectId id) {
		repository.delete(repository.findById(id));;
	}
	
}