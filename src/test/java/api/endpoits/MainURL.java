package api.endpoits;


//https://pcp-lnx-125:9790/cp-ws-rest-prov/RDU
//https://pcp-lnx-125:9790/cp-ws-rest-prov/RDU/
//https://pcp-lnx-125:9790/cp-ws-rest-prov/RDU/pcp-lnx-12.cisco.com
//https://pcp-lnx-125:9790/cp-ws-rest-prov/RDU/pcp-lnx-92
public class MainURL {

	
	public static String base_url="https://pcp-dpe-1:9790/cp-ws-rest-prov";
	
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
	
	//Server Operations

	public static String Allcnr_postUrl=base_url+"/getAllCNRs";
	public static String Alldpe_postUrl=base_url+"/getAllDPEs";
	public static String AllprovGp_postUrl=base_url+"/getAllProvGroups";
	public static String getCnr_postUrl=base_url+"/getCNRDetails";
	public static String getDefaults_postUrl=base_url+"/getDefaults";
	public static String getDPEDefaults_postUrl=base_url+"/getDPEDefaults";
	public static String getdpe_postUrl=base_url+"/getDPEDetails";
	public static String getExtensionPointSettings_postUrl=base_url+"/getExtensionPointSettings";
	public static String getLicenseKeyData_postUrl=base_url+"/getLicenseKeyData";
	public static String getProvGroupDetails_postUrl=base_url+"/getProvGroupDetails";
	public static String getRDUDefaults_postUrl=base_url+"/getRDUDefaults";
	public static String getRDUDetails_postUrl=base_url+"/getRDUDetails";
	public static String changeDefaults_putUrl=base_url+"/changeDefaults";
	public static String changeRDUDefaults_putUrl=base_url+"/changeRDUDefaults";
	
	//Search Operations
	
	public static String CosSearch_postUrl=base_url+"/cosSearch";
	public static String DhcpSearch_postUrl=base_url+"/dhcpSearch";
	public static String FileSearch_postUrl=base_url+"/fileSearch";
	public static String GroupSearch_postUrl=base_url+"/groupSearch";
	public static String SearchDevices_postUrl=base_url+"/searchDevices";
	
	
}

