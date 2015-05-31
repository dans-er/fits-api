package nl.knaw.dans.fits;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.jdom.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.harvard.hul.ois.fits.Fits;
import edu.harvard.hul.ois.fits.FitsOutput;
import edu.harvard.hul.ois.fits.exceptions.FitsConfigurationException;
import edu.harvard.hul.ois.fits.exceptions.FitsException;
import edu.harvard.hul.ois.fits.tools.Tool;

public class FitsInstance
{
    
    private static final Logger logger = LoggerFactory.getLogger(FitsInstance.class);
    
    // use absolute filenames for maven goals
    public static final String FITS_HOME = "/Users/ecco/git/fits-api/fits-0.8.5";
    
    private static FitsInstance INSTANCE = null;
    
    private static Fits FITS = null;
    
    private FitsInstance() throws FitsConfigurationException {
        String fitsLocation = FITS_HOME;
        logger.debug("Setting FITS_HOME as " + fitsLocation);
        BasicConfigurator.configure();
        FITS = new Fits(fitsLocation);        
    }
    
    public static FitsInstance instance() throws FitsConfigurationException {
        if (INSTANCE == null) {
            INSTANCE = new FitsInstance();
        }
        return INSTANCE;
    }
    
    public FitsOutput process(File file) throws FitsException {
        return FITS.examine(file);
    }
    
    public Document extract(File file) throws FitsException {
        return process(file).getFitsXml();
    }
    
    public List<String> getToolInfo() throws Exception {
        List<String> infoList = new ArrayList<String>();
        for (Tool tool : FITS.getToolbelt().getTools()) {
            infoList.add(tool.getToolInfo().print());
        }
        return infoList;
    }
    
    public boolean isStatisticsEnabled() {
        return Fits.enableStatistics;
    }
    
    public void setStatisticsEnabled(boolean enabled) {
        Fits.enableStatistics = enabled;
    }
}
