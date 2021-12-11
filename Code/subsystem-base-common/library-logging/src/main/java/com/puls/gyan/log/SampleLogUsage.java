/** 
 *  Sample application to show usage of logging famework
 */
package com.puls.gyan.log;

/**
 * @author pulkit1.s
 *
 */
public class SampleLogUsage {

    /**
     * @param args
     */
    public static void main(
            String[] args) {
      
        //set the TAG Id : This should come from rest clients as part of rest request .This has to be relatively unique 
        LogContextHolder.setLogContext("aSDADASSDASABCXBA");
    
        BaseLoggger logger = BaseLogFactory.getLogger(SampleLogUsage.class);
        logger.info("Samp_1398253495901","Happy Logging");
        
         
        
        //clear Tag-ID : will be done through a filter for rest/web request
        LogContextHolder.clear();
        
    }

}
