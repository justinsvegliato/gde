package gde.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The implementation of the CapturedData data structure that will be used by
 * MongoDB as well as the application.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class CapturedData extends Entry {

    /** the date when the data was captured */
    private Date captured;
    
    /** the frame number associated with the data */
    private Integer frameNumber;
    
    /** the map containing all of the data */
    private Map<String, String> data = new HashMap<String, String>();
    
    /** the id of the associated instance */
    private Integer instanceId;

    /**
     * Instantiates a newly-created CapturedData object.
     */
    public CapturedData() {
    }

    /**
     * Instantiates a newly-created CapturedData object.
     * 
     * @param id 
     */
    public CapturedData(Integer id) {
        super(id);
    }
    
    /**
     * Instantiates a newly-created CapturedData object.
     * 
     * @param captured the data when the data was captured
     * @param frameNumber the frame number associated with the data
     * @param data the map containing all of the data
     * @param instanceId the id of the associated instance
     */
    public CapturedData(Date captured, Integer frameNumber, Map<String, String> data, Integer instanceId) {
        this.captured = captured;
        this.frameNumber = frameNumber;
        this.data = data;
        this.instanceId = instanceId;
    }
    
    /**
     * Instantiates a newly-created CapturedData object.
     * 
     * @param captured the data when the data was captured
     * @param frameNumber the frame number associated with the data
     * @param data the map containing all of the data
     */
    public CapturedData(Date captured, Integer frameNumber, Map<String, String> data) {
        this(captured, frameNumber, data, -1);
    }
    
    /** 
     * Gets the date when the data was captured.
     * 
     * @return the date when the data was captured
     */
    public Date getCaptured() {
        return captured;
    }

    /**
     * Sets the date when the data was captured.
     * 
     * @param captured the date when the data was captured.
     */
    public void setCaptured(Date captured) {
        this.captured = captured;
    }

    /**
     * Gets the frame number associated with the data.
     * 
     * @return the frame number associated with the data
     */
    public Integer getFrameNumber() {
        return frameNumber;
    }
    
    /**
     * Sets the frame number associated with the data.
     * 
     * @param frameNumber the frame number associated with the data
     */
    public void setFrameNumber(Integer frameNumber) {
        this.frameNumber = frameNumber;
    }

    /**
     * Gets the id of the associated instance.
     * 
     * @return the id of the associated instance
     */
    public Integer getInstanceId() {
        return instanceId;
    }
    
    /** 
     * Sets the id of associated instance.
     * 
     * @param instanceId the id of the associated instance
     */
    public void setInstanceId(Integer instanceId) {
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
