package nl.knaw.dans.fits;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.jdom.Document;
import org.jdom.Namespace;
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
        //System.err.println(new XMLOutputter(Format.getPrettyFormat()).outputString(doc)); 
        Namespace ns = Namespace.getNamespace("http://hul.harvard.edu/ois/xml/ns/fits/fits_output");
        assertTrue(doc.getRootElement().getChild("identification", ns).getChildren().size() == 1);
        assertTrue(doc.getRootElement().getChild("fileinfo", ns).getChildren().size() > 0);
        assertTrue(doc.getRootElement().getChild("filestatus", ns).getChildren().size() > 0);
        assertTrue(doc.getRootElement().getChild("metadata", ns).getChildren().size() > 0);
    }
    
    @Test
    public void testGetToolInfo() throws Exception {
        Fitsi fits = Fitsi.instance();
        List<String> infoList = fits.getToolInfo();
//        for (String info : infoList) {
//            System.err.println(info);
//        }
        assertTrue(infoList.size() > 0);
    }
    
//    @Test
//    public void sysvar() {
//        System.getProperties().list(System.out);
//    }

}
