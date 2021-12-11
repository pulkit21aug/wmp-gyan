/** 
 *  Sample application to show usage of logging famework
 */
package com.puls.gyan.rest;

import org.springframework.web.client.RestTemplate;

import com.puls.gyan.log.BaseLogFactory;
import com.puls.gyan.log.BaseLoggger;
import com.puls.gyan.log.LogCommandLineInit;
import org.springframework.http.converter.json.GsonHttpMessageConverter;


/**
 * @author pulkit1.s
 *
 */
public class SampleUsage {

	static BaseLoggger logger = BaseLogFactory.getLogger(SampleUsage.class);
	/**
     * @param args
     */
    public static void main(
            String[] args) {
    	LogCommandLineInit.logInitialize();
    	
    	 String baseUrl = "http://Anubhav-Pandey-back.falcon.kronos.com/wfc/restcall/commonbusiness/v1/properties?key=";
    	 
    	 String key = baseUrl+"wfp.combinedpaycodes.LOADDATA_FROM_PAYCAT1MM";
      
    	 RestTemplate restTemplate = new RestTemplate();
    	 restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
    	 KronosPropertiesDto dto = restTemplate.getForObject(key, KronosPropertiesDto.class);
    	 logger.info(dto.getPropertyName()+":"+dto.getPropertyValue());
    	 
        
        
    }

}
