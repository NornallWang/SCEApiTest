<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"
	import="java.util.*,java.io.*,com.sohucs.*,com.sohucs.auth.*,com.sohucs.services.scs.*,com.sohucs.services.*,com.sohucs.services.scs.model.*"
%>
<%
try {
	String accesskey = "swByUyy02N2ZcZSyp5NtBQ==";
	String secretkey = "WY8rmVgpCVZL0YG7QgxCbA==";
	SohuCSCredentials myCredentials = new BasicSohuCSCredentials(accesskey, secretkey);
	SohuSCS scs= new SohuSCSClient(myCredentials);
	scs.setEndpoint("http://bjcnc.azure.sohuno.com");
	ObjectMetadata metadata = new ObjectMetadata();
	Map<String, String> userMetadata = new HashMap<String, String>();
	userMetadata.put("name", "lorna");
	metadata.setUserMetadata(userMetadata);
	String path = getServletContext().getRealPath("/bigfile.PNG");
	File f = new File(path);
	InputStream input = new FileInputStream(f);
	scs.putObject("scezktest", "kmtest3//IMG_2911.JPG", input, metadata);
	ObjectListing objectListing = scs.listObjects("new-bucket.amelie");
	List<SCSObjectSummary> list = objectListing.getObjectSummaries();
	for(SCSObjectSummary obj : list) {
		out.println("object:"+obj.getKey()+",size:"+obj.getSize());
	}
	}catch (Exception e) {
	}

%>