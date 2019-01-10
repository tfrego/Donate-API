package capstone.donate_api.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Users {
	@Id
	public ObjectId id;
	
	public String uid;
	public String name;
	public String email;
	public Location location;
	
	public Users(ObjectId id, String uid, String name, String email, Location location) {
		this.id = id;
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.location = location;
	}
	
	public String getId() { return id.toHexString(); }
	public void setId(ObjectId id) { this.id = id; }
	
	public String getUid() { return uid; }
	public void setUid(String uid) { this.uid = uid; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public Location getLocation() { return location; }
	public void setLocation(Location location) { this.location = location; }
}