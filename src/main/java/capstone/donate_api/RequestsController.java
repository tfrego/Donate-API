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
import capstone.donate_api.repositories.OffersRepository;
import capstone.donate_api.repositories.RequestsRepository;

@RestController
@RequestMapping("/requests")
public class RequestsController {
	
	@Autowired
	private RequestsRepository repository;
	
	@Autowired
	private OffersRepository offersRepository;
	
	@GetMapping("/")
	public List<Request> getAllItems() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Request getRequestById(@PathVariable("id") ObjectId id) {
		return repository.findById(id);
	}
	
	@PutMapping("/{id}")
	public void modifyRequestById(@PathVariable("id") ObjectId id, @Valid @RequestBody Request request) {
		request.setId(id);
		repository.save(request);
	}
	
	@PostMapping("/")
	public Request createRequest(@Valid @RequestBody Request request) {
		request.setId(ObjectId.get());
		repository.save(request);
		return request;
	}
	
	@DeleteMapping("/{id}")
	public void deleteRequest(@PathVariable("id") ObjectId id) {
		repository.delete(repository.findById(id));
	}
	
	@GetMapping("/active")
	public List<Request> getAllActiveItems() {
		return repository.findByStatus("active");
	}
	
	@GetMapping("/user/{id}")
	public List<Request> getRequestsByUser(@PathVariable("id") String id) {
		List<Request> userRequests = this.repository.findByUserIdAndStatus(id, "active");
		
		for (Request request : userRequests) {
			String titleMatch = request.title.toLowerCase();
			List<Offer> offerMatches = this.offersRepository.findByDescriptionLikeAndStatus(titleMatch, "active");
			request.setMatches(offerMatches);;
		}

		return userRequests;
	}
	
}