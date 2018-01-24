/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beer;

import java.util.LinkedList;

/**
 *
 * @author dvosy
 * 
 * Class to save data from mysql server.
 */
public class Data {

    public Data(int id, double lat, double longit, String brew, LinkedList<String> beer) {
        this.id = id;
        this.lat = lat;
        this.longit = longit;
        this.brew = brew;
        this.beer = beer;
    }

    public Data() {
        id = -1;
        beer = new LinkedList<>();
    }

    private int id;
    private double lat;
    private double longit;
    private String brew;
    private LinkedList<String> beer;

    public void setId(int id) {
        this.id = id;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLongit(double longit) {
        this.longit = longit;
    }

    public void setBrew(String brew) {
        this.brew = brew;
    }

    public void setBeer(String beer) {
        this.beer.add(beer);
    }

    public int getId() {
        return id;
    }

    public double getLat() {
        return lat;
    }

    public double getLongit() {
        return longit;
    }

    public String getBrew() {
        return brew;
    }

    public LinkedList<String> getBeer() {
        return beer;
    }
    
    @Override
    public String toString() {
        return "Data{" + "id=" + id + ", lat=" + lat + ", longit=" + longit + ", brew=" + brew + ", beer=" + beer + '}';
    }
    
    public int getBeerLength()
    {
        return beer == null? 0 : beer.size();
    }
    
}
