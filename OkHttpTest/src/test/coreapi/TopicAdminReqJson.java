package test.coreapi;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class TopicAdminReqJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<ReqJson> listReqJson = new ArrayList<ReqJson>();
		//
		ReqJson reqJson = new ReqJson();
		reqJson.setAid("");
		//
		listReqJson.add(reqJson);
		
		//
		Content content = new Content();
		content.setCover("");
		content.setInfor("这是帖子的内容：用于接口测试");
		content.setType(0);
		//
		List<Content> listContent = new ArrayList<Content>();
		listContent.add(content); 
		//
		reqJson.setContent(listContent);
	
		//
		Contents contents = new Contents();
		contents.setCover("");
		contents.setInfor("这是帖子的内容：用于接口测试");
		contents.setType(0);
		//
		List<Contents> listContents = new ArrayList<Contents>();
		listContents.add(contents);
		//
		reqJson.setContents(listContents);
		
		//
		reqJson.setContents(listContents);
		reqJson.setFid(2);
		reqJson.setIsAnonymous(0);
		reqJson.setIsHidden(0);
		reqJson.setIsOnlyAuthor(0);
		reqJson.setIsQuote(0);
		reqJson.setIsShowPosition(0);
		reqJson.setLatitude("");
		reqJson.setLocation("null");
		reqJson.setLongtitude("");
		
		
		//
		PollInfo pollInfo = new PollInfo();
		//
		List<Item> listItem = new ArrayList<Item>();
		
		//
		pollInfo.setExpiration(0);
		pollInfo.setIsImage(0);
		pollInfo.setItem(listItem);
		pollInfo.setMaxchoices(1);
		pollInfo.setMultiple(0);
		pollInfo.setPollPreview("");
		pollInfo.setVisible(0);
		//
		
		reqJson.setPollInfo(pollInfo);
		
		//
		reqJson.setReplyId(0);
		reqJson.setSortId(0);
		reqJson.setTi_id(0);
		reqJson.setTid(0);
		reqJson.setTitle("标题");
		reqJson.setTypeId(1);
		reqJson.setTypeOption("");
		reqJson.setTypeOptions("");
		
		//
		TopicAdminJsonBody jsonBody = new TopicAdminJsonBody();
		TopicAdminJson topicJsonData = new TopicAdminJson();
		
		topicJsonData.setBodyJson(reqJson);
		jsonBody.setJsonBody(topicJsonData);
		
		Gson topicAdminJsonDatas = new Gson();
		System.out.println(topicAdminJsonDatas.toJson(jsonBody));
	

	}

}
