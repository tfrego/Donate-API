package capstone.donate_api.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Items {
	@Id
	public ObjectId id;
	
	public String userId;
	public String type;
	public String title;
	public String category;
	public String description;
	public Integer qty;
	public String status;
	
	public Items() {}
	
	public Items(ObjectId id, String userId, String type, String title, String category, String description, Integer qty, String status) {
		this.id = id;
		this.userId = userId;
		this.type = type;
		this.title = title;
		this.category = category;
		this.description = description;
		this.qty = qty;
		this.status = status;
	}
	
	public String getId() { return id.toHexString(); }
	public void setId(ObjectId id) { this.id = id; }
	
	public String getUserId() { return userId; }
	public void setUserId(String userId) { this.userId = userId; }
	
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public Integer getQty() { return qty; }
	public void setQty(Integer qty) { this.qty = qty; }
	
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
}