package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace AddPlacePayload(String name, String language, String address)
	{
		AddPlace p=new AddPlace();
		p.setAccuracy(23);
		p.setName(name);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhoneNumber("(+91) 983 893 3937");
		p.setWebsite("https://www.udemy.com/ ");
		
		List<String> MyList=new ArrayList<String>();
		MyList.add("Paint shop");
		MyList.add("Cake Shop");
		p.setTypes(MyList);
		
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLog(33.427362);
		p.setLocation(l);
		return p;
	}
	
	public String deletePlacePayload(String placeId )
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}

}
