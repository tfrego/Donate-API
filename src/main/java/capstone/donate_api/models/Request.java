package capstone.donate_api.models;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Request {
	@Id
	public ObjectId id;
	
	public String userId;
	public String userName;
	public String title;
	public String category;
	public String description;
	public Integer qty;
	public String status;
	public Location location;
	public List<Offer> matches = new ArrayList<Offer>();

	
	public Request(ObjectId id, String userId, String userName, String title, String category, String description, Integer qty, String status, Location location) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.title = title;
		this.category = category;
		this.description = description;
		this.qty = qty;
		this.status = status;
		this.location = location;
	}
	
	public String getId() { return id.toHexString(); }
	public void setId(ObjectId id) { this.id = id; }
	
	public String getUserId() { return userId; }
	public void setUserId(String userId) { this.userId = userId; }
	
	public String getUserName() { return userName; }
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
	
	public String getDescription() { return description.toLowerCase(); }
	public void setDescription(String description) { this.description = description; }
	
	public Integer getQty() { return qty; }
	public void setQty(Integer qty) { this.qty = qty; }
	
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	
	public Location getLocation() { return location; }
	public void setLocation(Location location) { this.location = location; }
	
	public List<Offer> getMatches() { return matches; }
	public void setMatches(List<Offer> matches) { this.matches = matches; }
}