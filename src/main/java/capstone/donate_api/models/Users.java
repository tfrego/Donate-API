package capstone.donate_api.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Users {
	@Id
	public ObjectId id;
	
	public String name;
	public String email;
	public String accountType;
	public Location location;
	
	public Users() {}
	
	public Users(ObjectId id, String name, String email, String accountType, Location location) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.accountType = accountType;
		this.location = location;
	}
	
	public String getId() { return id.toHexString(); }
	public void setId(ObjectId id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getAccountType() { return accountType; }
	public void setAccountType(String accountType) { this.accountType = accountType; }
	
	public Location getLocation() { return location; }
	public void setLocation(Location location) { this.location = location; }
}