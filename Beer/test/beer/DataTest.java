/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beer;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dvosy
 */
public class DataTest {
    
    public DataTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 5;
        Data instance = new Data();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    @Test
    public void testSetLat() {
        System.out.println("setLat");
        double lat = 15.5;
        Data instance = new Data();
        instance.setLat(lat);
        assertEquals(lat, instance.getLat(), 0.0);
    }

    @Test
    public void testSetLongit() {
        System.out.println("setLongit");
        double longit = 15.5;
        Data instance = new Data();
        instance.setLongit(longit);
        assertEquals(longit, instance.getLongit(), 0.0);
    }

    @Test
    public void testSetBrew() {
        System.out.println("setBrew");
        String brew = "asdasdasd";
        Data instance = new Data();
        instance.setBrew(brew);
        assertEquals(brew, instance.getBrew());
    }

    @Test
    public void testSetBeer() {
        System.out.println("setBeer");
        String beer = "sadasdasd";
        Data instance = new Data();
        instance.setBeer(beer);
        assertEquals(1, instance.getBeerLength());
        assertEquals(beer, instance.getBeer().get(0));
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Data instance = new Data();
        int expResult = 5;
        instance.setId(expResult);
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLat() {
        System.out.println("getLat");
        Data instance = new Data();
        double expResult =15.5;
        instance.setLat(expResult);
        double result = instance.getLat();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetLongit() {
        System.out.println("getLongit");
        Data instance = new Data();
        double expResult =15.5;
        instance.setLongit(expResult);
        double result = instance.getLongit();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetBrew() {
        System.out.println("getBrew");
        Data instance = new Data();
        String expResult = "adasd";
        instance.setBrew(expResult);
        String result = instance.getBrew();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetBeer() {
        System.out.println("getBeer");
        Data instance = new Data();
        LinkedList<String> expResult = new LinkedList<>();
        expResult.add("asdasdasd");
        instance.setBeer("asdasdasd");
        LinkedList<String> result = instance.getBeer();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Data instance = new Data(-1, 60, 20, "HOME", null);
        String expResult = "Data{id=-1, lat=60.0, longit=20.0, brew=HOME, beer=null}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetBeerLength() {
        System.out.println("getBeerLength");
        Data instance = new Data();
        int expResult = 0;
        int result = instance.getBeerLength();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetBeerLength1() {
        System.out.println("getBeerLength");
        Data instance = new Data();
        instance.setBeer("asdasd");
        instance.setBeer("asdasd");
        int expResult = 2;
        int result = instance.getBeerLength();
        assertEquals(expResult, result);
    }
    
}
