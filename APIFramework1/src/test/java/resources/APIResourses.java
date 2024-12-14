package resources;

//enum is a special class in Java which has the collection of constants or methods
public enum APIResourses {
	
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;
	APIResourses(String resourse)
	{
		this.resource=resourse;
	}
	
	public String getResource()
	{
		return resource;
	}

}
