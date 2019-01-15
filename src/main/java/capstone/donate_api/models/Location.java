package capstone.donate_api.models;

public class Location {
	public String lat;
	public String lng;
	
	public Location(String lat, String lng) {
		this.lat = lat;
		this.lng = lng;
	}
	
	public String getLat() { return lat; }
	public void setLat(String lat) { this.lat = lat; }
	
	public String getLng() { return lng; }
	public void setLng(String lng) { this.lng = lng; }
}