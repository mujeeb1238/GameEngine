/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex
 */
public class Sandbox {

    public Sandbox() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Test
    public void testNegativeFor()
    {
        System.out.println("testage");
        
        for (int i = 0; i <= 10; i++)
        {
            System.out.println(i);
        }

        for (int i = 15; i >= 0; i--)
        {
            System.out.println(i);
        }
    }

}