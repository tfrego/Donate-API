package capstone.donate_api.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import capstone.donate_api.models.User;

public interface UsersRepository extends MongoRepository<User, String> {
	User findById(ObjectId id);
	User findByUid(String uid);
}