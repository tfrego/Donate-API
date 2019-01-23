package capstone.donate_api.models;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class User {
	@Id
	public ObjectId id;
	
	public String uid;
	public String name;
	public String email;
	public String about;
	public String photo;
	public Location location;
	public List<Request> requests = new ArrayList<Request>();
	
	public User(ObjectId id, String uid, String name, String email, String about, String photo, Location location) {
		this.id = id;
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.about = about;
		this.photo = photo;
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
	
	public String getAbout() { return about; }
	public void setAbout(String about) { this.about = about; }
	
	public String getPhoto() { return photo; }
	public void setPhoto(String photo) { this.photo = photo; }
	
	public Location getLocation() { return location; }
	public void setLocation(Location location) { this.location = location; }
	
	public List<Request> getRequests() { return requests; }
	public void setRequests(List<Request> requests) { this.requests = requests; }
}