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
@RequestMapping("/offers")
public class OffersController {
	
	@Autowired
	private OffersRepository repository;
	
	@Autowired
	private RequestsRepository requestsRepository;
	
	@GetMapping("/")
	public List<Offer> getAllItems() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Offer getOfferById(@PathVariable("id") ObjectId id) {
		return repository.findById(id);
	}
	
	@PutMapping("/{id}")
	public void modifyOfferById(@PathVariable("id") ObjectId id, @Valid @RequestBody Offer offer) {
		offer.setId(id);
		repository.save(offer);
	}
	
	@PostMapping("/")
	public Offer createOffer(@Valid @RequestBody Offer offer) {
		offer.setId(ObjectId.get());
		repository.save(offer);
		return offer;
	}
	
	@DeleteMapping("/{id}")
	public void deleteOffer(@PathVariable("id") ObjectId id) {
		repository.delete(repository.findById(id));
	}
	
	@GetMapping("/user/{id}")
	public List<Offer> getOffersByUser(@PathVariable("id") String id) {
		List<Offer> userOffers = this.repository.findByUserId(id);
		
		for (Offer offer : userOffers) {
			String titleMatch = offer.title.toLowerCase();
			List<Request> requestMatches = this.requestsRepository.findByDescriptionLike(titleMatch);
			offer.setMatches(requestMatches);;
		}

		return userOffers;
	}
	
}