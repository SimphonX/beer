/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beer;

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
public class CalculatorTest {
    
    public CalculatorTest() {
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
    public void testDistance() {
        System.out.println("distance");
        double startLat = 50;
        double startLong = 20;
        double endLat = 60;
        double endLong = 30;
        double expResult = 1278.730;
        double result = Calculator.distance(startLat, startLong, endLat, endLong);
        assertEquals(expResult, result, 0.001);
    }

    @Test
    public void testHaversin() {
        System.out.println("haversin");
        double val = 50;
        double expResult = 0.0175;
        double result = Calculator.haversin(val);
        assertEquals(expResult, result, 0.0001);
    }
    
}
