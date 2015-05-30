package nl.knaw.dans.fits;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.jdom.Document;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.junit.Test;

public class FitsiTest
{
    
    @Test
    public void testInstance() throws Exception {
        Fitsi fits1 = Fitsi.instance();
        Fitsi fits2 = Fitsi.instance();
        assertEquals(fits1, fits2);
    }
    
    @Test
    public void testGetDocument() throws Exception {
        Fitsi fits = Fitsi.instance();
        Document doc = fits.getDocument(new File("/Users/ecco/git/fits-api/src/test/resources/test-files/DSC00323.jpg"));
        System.err.println(new XMLOutputter(Format.getPrettyFormat()).outputString(doc));
        
    }
    
    

}
