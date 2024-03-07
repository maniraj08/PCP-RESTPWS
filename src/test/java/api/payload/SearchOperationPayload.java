package api.payload;

public class SearchOperationPayload {

	
	String deviceType;
	String query;
	String sessionId;
	
	String fileType;
	int maxResults;
	String name;
	
	String groupNamePattern;
	String returnParameters;
	String start;
	
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public int getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroupNamePattern() {
		return groupNamePattern;
	}
	public void setGroupNamePattern(String groupNamePattern) {
		this.groupNamePattern = groupNamePattern;
	}
	public String getReturnParameters() {
		return returnParameters;
	}
	public void setReturnParameters(String returnParameters) {
		this.returnParameters = returnParameters;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
}
