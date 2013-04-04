package gde.util;

import java.util.Map;

public class Request {

    private Integer gameId;
    private Integer instanceId;
    private Integer frameNumber;
    private Map<String, String> data;

    public Request() {
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(Integer instanceId) {
        this.instanceId = instanceId;
    }
    
    public Integer getFrameNumber() {
        return frameNumber;
    }

    public void getFrameNumber(Integer frameNumber) {
        this.frameNumber = frameNumber;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
    
}
