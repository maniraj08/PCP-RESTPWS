package api.endpoits;


//https://pcp-lnx-125:9790/cp-ws-rest-prov/RDU
//https://pcp-lnx-125:9790/cp-ws-rest-prov/RDU/
//https://pcp-lnx-125:9790/cp-ws-rest-prov/RDU/pcp-lnx-12.cisco.com
//https://pcp-lnx-125:9790/cp-ws-rest-prov/RDU/pcp-lnx-92
public class MainURL {

	
	public static String base_url="https://pcp-lnx-125:9790/cp-ws-rest-prov";
	
	//restpws-operations module
	
	public static String post_url=base_url+"/RDU/";
	public static String get_url=base_url+"/RDU/";
	public static String update_url=base_url+"/RDU/{rduHost}";
	public static String delete_url=base_url+"/RDU/{rduHost}";
	
	
	//CreateSession
	
	public static String CS_postUrl=base_url+"/createSession";
	
	//COS Operation Module
	
	public static String cos_postUrl=base_url+"/addCOS";
	public static String cos_getUrl=base_url+"/getClassOfService";
	public static String cos_updateUrl=base_url+"/updateCOS";
	public static String cos_deleteUrl=base_url+"/deleteCOS";
}
