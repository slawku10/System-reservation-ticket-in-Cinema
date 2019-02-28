/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pdf;

import application.kino.model.Reservation;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maksymilian
 */
public class PdfItextTest {
    
    public PdfItextTest() {
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

    /**
     * Test of createPdf method, of class PdfItext.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCreatePdf() throws Exception {
        System.out.println("createPdf");
        List<Reservation> res = new ArrayList<>();
        ByteArrayOutputStream result = PdfItext.createPdf(res);
        assertNotNull(result);
    }
    
}
