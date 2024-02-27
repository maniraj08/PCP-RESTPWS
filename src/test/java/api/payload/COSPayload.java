package api.payload;

import java.util.HashMap;

public class COSPayload {

	String deviceType;
	String name;
	String sessionId;
	//String properties;
	HashMap <String, String> properties;
	
	String resourceName;
	
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public HashMap<String, String> getProperties() {
		return properties;
	}
	public void setProperties(HashMap<String, String> properties) {
		this.properties = properties;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	/*public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}*/

}
