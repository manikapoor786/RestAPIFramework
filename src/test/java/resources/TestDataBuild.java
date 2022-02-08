package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.PutLocation;
import pojo.SubLocation;

public class TestDataBuild {

	public PutLocation addPlacePayLoad(String name, String language, String address)
	{
		PutLocation p= new PutLocation();
		 p.setAccuracy(50);
		 p.setAddress(address);
		 p.setLanguage(language);
		 p.setPhone_number("(+91) 983 893 3937");
		 p.setName(name);
		 p.setWebsite("http://google.com");
		 List<String> mylist= new ArrayList<String>();
		 mylist.add("shoe park");
		 mylist.add("shop");
		 p.setTypes(mylist);
		 
		 SubLocation s= new SubLocation();
		 s.setLat(-38.383494);
		 s.setLng(33.427362);
		 p.setLocation(s);
		 return p;
	}
	
	public String deletePlacePayload(String place_id)
	{
		return "{\r\n    \"place_id\":\""+place_id+"\"\r\n}\r\n";
	}
	
}
