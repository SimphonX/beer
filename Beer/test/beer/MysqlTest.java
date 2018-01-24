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
public class MysqlTest {
    
    public MysqlTest() {
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
    public void testConnect() {
        System.out.println("connect");
        Mysql instance = new Mysql(60,20);
        instance.connect();
        
    }

    @Test
    public void testGetData() {
        System.out.println("getData");
        Mysql instance = new Mysql(60,20);
        instance.connect();
        LinkedList<Data> result = instance.getData();
        assertEquals(18, result.size());
    }
    
}
