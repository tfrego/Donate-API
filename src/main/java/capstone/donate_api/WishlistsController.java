package capstone.donate_api;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import capstone.donate_api.models.Wishlists;
import capstone.donate_api.repositories.WishlistsRepository;

@RestController
@RequestMapping("/wishlists")
public class WishlistsController {
	@Autowired
	private WishlistsRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Wishlists> getAllWishlists() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Wishlists getWishlistById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyWishlistById(@PathVariable("id") ObjectId id, @Valid @RequestBody Wishlists wishlists) {
		wishlists.set_id(id);
		repository.save(wishlists);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Wishlists createWishlist(@Valid @RequestBody Wishlists wishlists) {
		wishlists.set_id(ObjectId.get());
		repository.save(wishlists);
		return wishlists;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteWishlist(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));;
	}
	
}