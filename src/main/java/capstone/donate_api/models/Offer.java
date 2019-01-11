package capstone.donate_api.models;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Offer {
	@Id
	public ObjectId id;
	
	public String userId;
	public String title;
	public String category;
	public String description;
	public List<String> images;
	public Integer qty;
	public String status;
	public List<Request> matches = new ArrayList<Request>();

	
	public Offer(ObjectId id, String userId, String title, String category, String description, List<String> images, Integer qty, String status) {
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.category = category;
		this.description = description;
		this.images = images;
		this.qty = qty;
		this.status = status;
	}
	
	public String getId() { return id.toHexString(); }
	public void setId(ObjectId id) { this.id = id; }
	
	public String getUserId() { return userId; }
	public void setUserId(String userId) { this.userId = userId; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public List<String> getImages() { return images; }
	public void setImages(List<String> images) { this.images = images; }
	
	public Integer getQty() { return qty; }
	public void setQty(Integer qty) { this.qty = qty; }
	
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	
	public List<Request> getMatches() { return matches; }
	public void setMatches(List<Request> matches) { this.matches = matches; }
}