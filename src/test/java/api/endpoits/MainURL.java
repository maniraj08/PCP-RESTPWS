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
	
	
}
