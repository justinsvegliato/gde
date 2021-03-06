package gde.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.bson.types.ObjectId;

/** 
 * All classes must implement Entry in order to be used by the provided helper
 * classes. It houses information that is necessary for MongoDB, Jongo, and 
 * Jackson.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public abstract class Entry {
    
    /** the id required by Mongo */
    @JsonProperty("_id")
    private ObjectId key = null;
    
    /** the date when the entry was last updated */
    protected Date updateDate = null;

    /** 
     * Instantiates a newly-created Entry object.
     */
    public Entry() {
       
    }
    
    /**
     * Gets the date when the entry was updated.
     *
     * @return the date when this object was updated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * Sets the date when the entry was last updated.
     *
     * @param updateDate the date when the entry was last updated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * Gets the id required by Mongo.
     *
     * @return the id required by Mongo
     */
    public ObjectId getKey() {
        return key;
    }

    /**
     * Sets the id required by Mongo.
     *
     * @param key the id required by Mongo
     */
    public void setKey(ObjectId key) {
        this.key = key;
    }
    
    /**
     * Gets the date when the entry was created.
     * 
     * @return the date when the entry was created
     */
    public Date getCreateDate() {
        if(key == null)
            return null;
        
        return new Date(key.getTime());
    }
}
