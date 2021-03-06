package capstone.donate_api.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import capstone.donate_api.models.Offer;

public interface OffersRepository extends MongoRepository<Offer, String> {
	Offer findById(ObjectId id);
	
	List<Offer> findByStatus(String status);
	
	List<Offer> findByUserIdAndStatus(String id, String status);
	
	List<Offer> findByDescriptionLikeAndStatus(String description, String status);
}