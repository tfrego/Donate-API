package capstone.donate_api.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import capstone.donate_api.models.Users;

public interface UsersRepository extends MongoRepository<Users, String> {
	Users findById(ObjectId id);
	Users findByUid(String uid);
}