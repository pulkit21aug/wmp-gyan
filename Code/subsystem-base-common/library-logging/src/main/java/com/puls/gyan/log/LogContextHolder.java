/**
 * Used for tagging logs : based on the identified send by third party systems
 * or generated internally to tie up the logs across api calls
 * Uniquely stamp each log request initiated from the same client interaction
 */
package com.puls.gyan.log;

/**
 * @author pulkit1.s
 * 
 */
public class LogContextHolder {

    private static final ThreadLocal<String> LOGCONTEXT = new ThreadLocal<String>();

    /**
     * sets the externalIdentifier used to tag logs in thread local
     * 
     * @param tagId
     */
    public static void setLogContext(
            String tagId) {
        LOGCONTEXT.set(tagId);
    }

    /**
     * clears the context
     */
    public static void clear() {
        LOGCONTEXT.remove();
    }

    /**
     * returns the tagId
     * @return
     */
    public static String getLogContext() {
        return LOGCONTEXT.get();
    }

}
