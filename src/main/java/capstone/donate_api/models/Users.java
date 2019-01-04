package capstone.donate_api.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Users {
	@Id
	public ObjectId _id;
	
	public String name;
	public String email;
	public String account_type;
	public Location location;
	
	public Users() {}
	
	public Users(ObjectId _id, String name, String email, String account_type, Location location) {
		this._id = _id;
		this.name = name;
		this.email = email;
		this.account_type = account_type;
		this.location = location;
	}
	
	public String get_id() { return _id.toHexString(); }
	public void set_id(ObjectId _id) { this._id = _id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getAccount_type() { return account_type; }
	public void setAccount_type(String account_type) { this.account_type = account_type; }
	
	public Location getLocation() { return location; }
	public void setLocation(Location location) { this.location = location; }
}