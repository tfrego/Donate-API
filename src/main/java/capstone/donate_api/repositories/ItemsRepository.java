package capstone.donate_api.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import capstone.donate_api.models.Items;

public interface ItemsRepository extends MongoRepository<Items, String> {
	Items findById(ObjectId id);
	
	List<Items> findByUserId(String id);
	
	List<Items> findByTitleLikeAndType(String title, String type);

	List<Items> findByUserIdAndType(String id, String type);

}