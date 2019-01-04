package capstone.donate_api.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import capstone.donate_api.models.Wishlists;

public interface WishlistsRepository extends MongoRepository<Wishlists, String> {
	Wishlists findBy_id(ObjectId _id);
}