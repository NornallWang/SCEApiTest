package test;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class Jemter_userLogin extends AbstractJavaSamplerClient{
	private static String label="Jmeter_UserLogin";	//����lable���ƣ���ʾ��Jemter�����
	private String url;
	private String data;
	
	public void setUp(){
		System.out.println("setupTest");
	}

	@Override
	public SampleResult runTest(JavaSamplerContext axg0){
		url = axg0.getParameter("url");
		data = axg0.getParameter("data");
		SampleResult sr = new SampleResult();
		sr.setSampleLabel(label);
		
		TestApiGetUserLogin getUserLoginApi = new TestApiGetUserLogin();
		sr.sampleStart();
		
		//���ñ�ѹ��ӿڵķ���
		getUserLoginApi.PostJson(url, data);
		sr.setSuccessful(true);
		
		sr.sampleEnd();
		return sr;
	}
	
	public void tearDown(JavaSamplerContext axg0){
		super.teardownTest(axg0);
	}
	
	public Arguments getDefaultParameters(){
		Arguments params = new Arguments();
		params.addArgument("url","");
		params.addArgument("data", "");
		
		return params;
	}
}
