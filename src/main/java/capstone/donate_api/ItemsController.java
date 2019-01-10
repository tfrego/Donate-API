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

import capstone.donate_api.models.Items;
import capstone.donate_api.repositories.ItemsRepository;

@RestController
@RequestMapping("/items")
public class ItemsController {
	@Autowired
	private ItemsRepository repository;
	
	@GetMapping("/")
	public List<Items> getAllItems() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Items getItemById(@PathVariable("id") ObjectId id) {
		return repository.findById(id);
	}
	
	@PutMapping("/{id}")
	public void modifyItemById(@PathVariable("id") ObjectId id, @Valid @RequestBody Items items) {
		items.setId(id);
		repository.save(items);
	}
	
	@PostMapping("/")
	public Items createItem(@Valid @RequestBody Items items) {
		items.setId(ObjectId.get());
		repository.save(items);
		return items;
	}
	
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable("id") ObjectId id) {
		repository.delete(repository.findById(id));
	}
	
	@GetMapping("/requests/{id}")
	public List<Items> getRequestsByUser(@PathVariable("id") String id) {
		List<Items> requests = this.repository.findByUserIdAndType(id, "request");

		return requests;
	}
	
	@GetMapping("/offers/{id}")
	public List<Items> getOffersByUser(@PathVariable("id") String id) {
		List<Items> offers = this.repository.findByUserIdAndType(id, "offer");

		return offers;
	}
	
	@GetMapping("/matches/{id}")
	public List<Items> getUserRequestsMatches(@PathVariable("id") String id) {
		List<Items> userRequests = this.repository.findByUserIdAndType(id, "request");
		
		for (Items request : userRequests) {
			String titleMatch = request.title;
			List<Items> matches = this.repository.findByTitleLikeAndType(titleMatch, "offer");
			request.setMatches(matches);
		}
		
		return userRequests;
	}
	
}