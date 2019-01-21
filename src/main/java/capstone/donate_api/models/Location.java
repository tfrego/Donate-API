package capstone.donate_api.models;

public class Location {
	public Double lat;
	public Double lng;
	public String cityState;
	
	public Location(Double lat, Double lng, String cityState) {
		this.lat = lat;
		this.lng = lng;
		this.cityState = cityState;
	}
	
	public Double getLat() { return lat; }
	public void setLat(Double lat) { this.lat = lat; }
	
	public Double getLng() { return lng; }
	public void setLng(Double lng) { this.lng = lng; }
	
	public String getCityState() { return cityState; }
	public void setCityState(String cityState) { this.cityState = cityState; }
	
}