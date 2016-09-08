package com.goeuro.model;
/**
 * Class GeoPosition is a pojo/model class for GeoPosition of a City
 * 
 * @author Anandh 
 *
 */
public class GeoPosition {
	    private Double longitude;

	    private Double latitude; 

	    public Double getLongitude ()
	    {
	        return longitude;
	    }

	    public void setLongitude (Double longitude)
	    {
	        this.longitude = longitude;
	    }

	    public Double getLatitude ()
	    {
	        return latitude;
	    }

	    public void setLatitude (Double latitude)
	    {
	        this.latitude = latitude;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [longitude = "+longitude.toString()+", latitude = "+latitude.toString()+"]";
	    }

}
