package gde.models;

import java.util.HashMap;
import java.util.Map;

/**
 * The implementation of the CapturedData data structure that is used by
 * MongoDB as well as the application.
 *
 * @author Justin Svegliato and Andrew Evans
 */
public class CapturedData extends Entry {
    
    /** the map containing all of the data */  
    private Map<String, String> data = new HashMap<String, String>();
    
    /** the id of the associated instance */
    private String instanceId;

    /**
     * Instantiates a newly-created CapturedData object.
     */
    public CapturedData() {
    }

    /**
     * Instantiates a newly-created CapturedData object.
     *
     * @param data the map containing all of the data
     * @param instanceId the id of the associated instance
     */
    public CapturedData(Map<String, String> data, String instanceId) {
        this.data = data;
        this.instanceId = instanceId;
    }
    
    /**
     * Gets the id of the associated instance.
     *
     * @return the id of the associated instance
     */
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * Sets the id of associated instance.
     *
     * @param instanceId the id of the associated instance
     */
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    /**
     * Gets the map containing all of the data.
     *
     * @return the map containing all of the data
     */
    public Map<String, String> getData() {
        return data;
    }

    /**
     * Sets the map containing all of the data.
     *
     * @param data the map containing all of the data
     */
    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
