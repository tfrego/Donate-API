package capstone.donate_api.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Wishlists {
	@Id
	public ObjectId _id;
	
	public String user_id;
	public String item;
	public String category;
	public String description;
	public Integer qty;
	public String status;
	
	public Wishlists() {}
	
	public Wishlists(ObjectId _id, String item, String category, String description, Integer qty, String status) {
		this._id = _id;
		this.item = item;
		this.category = category;
		this.description = description;
		this.qty = qty;
		this.status = status;
	}
	
	public String get_id() { return _id.toHexString(); }
	public void set_id(ObjectId _id) { this._id = _id; }
	
	public String getItem() { return item; }
	public void setItem(String item) { this.item = item; }
	
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public Integer getQty() { return qty; }
	public void setQty(Integer qty) { this.qty = qty; }
	
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
}