package api.payload;

import java.util.HashMap;

public class ServerOperationsPayload {
	
	String hostName;
	String sessionId;
	String provGroupName;
	String deviceTypeName;
	
	HashMap <String, String> propertiesToAdd;
	HashMap <String, String> properties;
	
	public HashMap<String, String> getProperties() {
		return properties;
	}
	public void setProperties(HashMap<String, String> properties) {
		this.properties = properties;
	}
	public HashMap<String, String> getPropertiesToAdd() {
		return propertiesToAdd;
	}
	public void setPropertiesToAdd(HashMap<String, String> propertiesToAdd) {
		this.propertiesToAdd = propertiesToAdd;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getProvGroupName() {
		return provGroupName;
	}
	public void setProvGroupName(String provGroupName) {
		this.provGroupName = provGroupName;
	}
	public String getDeviceTypeName() {
		return deviceTypeName;
	}
	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
	}
	

}
