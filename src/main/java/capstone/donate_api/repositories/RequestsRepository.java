package capstone.donate_api.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import capstone.donate_api.models.Request;

public interface RequestsRepository extends MongoRepository<Request, String> {
	Request findById(ObjectId id);
	
	List<Request> findByUserId(String id);
	
	List<Request> findByDescriptionLike(String description);
}