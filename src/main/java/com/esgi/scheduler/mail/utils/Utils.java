package com.esgi.scheduler.mail.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class Utils {

    private static Properties properties;

    public Utils(String p_properties) {
        properties = getProperties(p_properties);
    }

    public Properties getProperties(String p_properties) {
       
        FileInputStream propertyFileInputStream = null;
    	try {
			propertyFileInputStream = new FileInputStream(p_properties);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        Properties p = new Properties();
        if (propertyFileInputStream != null) {

            try {
                p.load(propertyFileInputStream);
            } catch (IOException ioe) {
            	System.out.println(ioe);
            }
        }
        return p;
    }

    public String getProperty(String property) {
        String propValue = null;
        if (properties != null) {
        	
            propValue = resolveEnvVars(properties.getProperty(property));
        }
        return propValue;
    }
    
    /*
     * Returns input string with environment variable references expanded, e.g. $SOME_VAR or ${SOME_VAR}
     */
    private String resolveEnvVars(final String input)
    {
        if (null == input)
        {
            return null;
        }
        // match ${ENV_VAR_NAME} or $ENV_VAR_NAME
        Pattern p = Pattern.compile("\\$\\{(\\w+)\\}|\\$(\\w+)");
        Matcher m = p.matcher(input); // get a matcher object
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            String envVarName = null == m.group(1) ? m.group(2) : m.group(1);
            String envVarValue = System.getenv(envVarName);
           if( null == envVarValue){
        	   sb.append( "");
           }
           else{
        	   envVarValue= envVarValue.replace("\\", "\\\\");
        	   m.appendReplacement(sb, null == envVarValue ? "" : envVarValue);
           }
        }
        m.appendTail(sb);
        return sb.toString();
    }
    
}
