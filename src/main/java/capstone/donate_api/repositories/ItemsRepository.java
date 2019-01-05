package capstone.donate_api.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import capstone.donate_api.models.Items;

public interface ItemsRepository extends MongoRepository<Items, String> {
	Items findById(ObjectId id);
	
	@Query(value = "{userId:?0}")
	List<Items> findByUserId(String id);

}