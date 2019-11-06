/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package location;

/**
 *
 * @author dewang
 */
public class Location {
    
    private double latitude;
    private double longitude;
    
    public double[] getLocation()
    {   
        double[] loc = {latitude,longitude};
        return loc;
    }
    
    public boolean changeLocation(double lat,double lon)
    {
        if( lat<0.0 || lat>90.0 || lon<0.0 || lon>180.0)
            return false;
        
        this.latitude = lat;
        this.longitude = lon;
        return true;
           
    }
    
}
