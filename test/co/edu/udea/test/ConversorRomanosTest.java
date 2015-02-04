/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.test;

import co.edu.udea.appempresariales.ConversorRomanos;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class ConversorRomanosTest {
    
    ConversorRomanos cv = new ConversorRomanos();
    
    public ConversorRomanosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * se prueba que no exitan D seguidas
     */   
    @Test
    public void noVRepetidas() {
        boolean b = cv.noVLDRepetidas("XVV");
        assertEquals(false, b);
    }
    
    /**
     * se prueba que no exitan D seguidas
     */
    @Test
    public void noDRepetidas() {
        boolean b = cv.noVLDRepetidas("MDD");
        assertEquals(false, b);
    }
    /**
     * se prueba que no exitan mas de 3 I seguidas
     */
    @Test
    public void noIRepetidas() {
        boolean b = cv.noIXCMRepetidas("IIII");
        assertEquals(false, b);
    }
    
     /**
     * se prueba que no exitan mas de 3 M seguidas
     */
    @Test
    public void noMRepetidas() {
        boolean b = cv.noIXCMRepetidas("MMMMM");
        assertEquals(false, b);
    }
    /**
     * la cadena solo tiene los simbolos permitidos
     */
    @Test
    public void contieneLetrasRomanos() {
        boolean b = cv.soloRomanos("lafjjkf");
        assertEquals(false, b);
    }
    

    /**
     * se prueba que la i solo esté antes de la V
     */
    @Test
    public void iAntesV() {
        int respuesta = cv.transformar("XIV");
        assertEquals(14, respuesta);
    }
    
    /**
     * se prueba que la i solo reste a la V
     */
    @Test
    public void iAntesv() {
        int respuesta = cv.transformar("XID");
        assertEquals(-1, respuesta);
    }
    
    /**
     * se prueba que la x solo reste a la L
     */
    @Test
    public void xAntesL() {
        int respuesta = cv.transformar("CXL");
        assertEquals(140, respuesta);
    }
    
    /**
     * se prueba que la x solo reste a la L
     */
    @Test
    public void xAntesl() {
        int respuesta = cv.transformar("CXM");
        assertEquals(-1, respuesta);
    }
    
    /**
     * el numero romano VL es probado
     */
    @Test
    public void vl(){
        int respuesta = cv.transformar("VL");
        assertEquals(-1, respuesta);
    }
    
    /**
     * el numero romano IIII es probado
     */
    @Test
    public void IIII(){
        int respuesta = cv.transformar("IIII");
        assertEquals(-1, respuesta);
    }
    
    /**
     * el numero romano VIV es probado
     */
    @Test
    public void VIV(){
        int respuesta = cv.transformar("VIV");
        assertEquals(-1, respuesta);
    }
    
    /**
     * el numero romano XXL es probado
     */
    @Test
    public void XXM(){
        int respuesta = cv.transformar("XXM");
        assertEquals(-1, respuesta);
    }  
    
    /**
     * el numero romano MMCMXCVI es probado
     */
    @Test
    public void MMCMXCVI(){
        int respuesta = cv.transformar("MMCMXCVI");
        assertEquals(2996, respuesta);
    }  
    
    /**
     * el numero romano CMXCIX es probado
     */
    @Test
    public void CMXCIX(){
        int respuesta = cv.transformar("CMXCIX");
        assertEquals(999, respuesta);
    }  
    
}
