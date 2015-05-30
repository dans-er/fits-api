package nl.knaw.dans.fits;

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.jdom.Document;

import edu.harvard.hul.ois.fits.Fits;
import edu.harvard.hul.ois.fits.FitsOutput;
import edu.harvard.hul.ois.fits.exceptions.FitsConfigurationException;
import edu.harvard.hul.ois.fits.exceptions.FitsException;

public class Fitsi
{
    
    // use absolute filenames for maven goals
    public static final String FITS_HOME = "/Users/ecco/git/fits-api/fits-0.8.5";
    
    private static Fitsi INSTANCE = null;
    
    private static Fits FITS = null;
    
    private Fitsi() throws FitsConfigurationException {
        BasicConfigurator.configure();
        FITS = new Fits(FITS_HOME);
        
    }
    
    public static Fitsi instance() throws FitsConfigurationException {
        if (INSTANCE == null) {
            INSTANCE = new Fitsi();
        }
        return INSTANCE;
    }
    
    public Document getDocument(File file) throws FitsException {
        FitsOutput fout = FITS.examine(file);
        return fout.getFitsXml();
    }
    

}
