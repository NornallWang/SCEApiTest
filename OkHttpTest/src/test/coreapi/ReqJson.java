package test.coreapi;

import java.util.List;

public class ReqJson {
	
	private String aid;
	private List<Content> content;
	private List<Contents> contents;
	private int fid;
	private int isAnonymous;
	private int isHidden;
	private int isOnlyAuthor;
	private int isQuote;
	private int isShowPosition;
	private String latitude;
	private String location;
	private String longtitude;
	private Object pollInfo;
	private int replyId;
	private int sortId;
	private int ti_id;
	private int tid;
	private String title;
	private int typeId;
	private String typeOptions;
	private String typeOption;
	
	
	public String getAid(){
		return aid;
	}
	
	public void setAid(String aid){
		this.aid = aid;
	}
	/**
	public String getContent(){
		return content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	*/
	
	public List<Contents> getContents(){
		return contents;
	}
	
	public void setContents(List<Contents> contents){
		this.contents = contents;
	}
	
	public int getFid(){
		return fid;
	}
	
	public void setFid(int fid){
		this.fid = fid;
	}
	
	public int getIsAnonymous(){
		return isAnonymous;
	}
	
	public void setIsAnonymous(int isAnonymous){
		this.isAnonymous = isAnonymous;
	}
	
	public int getIsHidden(){
		return isHidden;
	}
	
	public void setIsHidden(int isHidden){
		this.isHidden = isHidden;
	}
	
	public int getIsOnlyAuthor(){
		return isOnlyAuthor;
	}
	
	public void setIsOnlyAuthor(int isOnlyAuthor){
		this.isOnlyAuthor = isOnlyAuthor;
	}
	
	public int getIsQuote(){
		return isQuote;
	}
	
	public void setIsQuote(int isQuote){
		this.isQuote = isQuote;
	}
	
	public int getIsShowPosition(){
		return isShowPosition;
	}
	
	public void setIsShowPosition(int isShowPosition){
		this.isShowPosition = isShowPosition;
	}
	
	public String getLatitude(){
		return latitude;
	}
	
	public void setLatitude(String latitude){
		this.latitude = latitude;
	}
	
	public String getLocation(){
		return location;
	}
	
	public void setLocation(String location){
		this.location = location;
	}
	
	public String getLongtitude(){
		return longtitude;
	}
	
	public void setLongtitude(String longtitude){
		this.longtitude = longtitude;
	}

	public Object getPollInfo(){
		return pollInfo;
	}
	
	public void setPollInfo(Object pollInfo){
		this.pollInfo = pollInfo;
	}
	
	
	public int getReplyId(){
		return replyId;
	}
	
	public void setReplyId(int replyId){
		this.replyId = replyId;
	}
	
	public int getSortId(){
		return sortId;
	}
	
	public void setSortId(int sortId){
		this.sortId = sortId;
	}
	
	public int getTi_id(){
		return ti_id;
	}
	
	public void setTi_id(int ti_id){
		this.ti_id = ti_id;
	}
	
	public int getTid(){
		return tid;
	}
	
	public void setTid(int tid){
		this.tid = tid;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public int getTypeId(){
		return typeId;
	}
	
	public void setTypeId(int typeId){
		this.typeId = typeId;
	}
	
	public String getTypeOption(){
		return typeOption;
	}
	
	public void setTypeOption(String typeOption){
		this.typeOption = typeOption;
	}
	
	public String getTypeOptions(){
		return typeOptions;
	}
	
	public void setTypeOptions(String typeOptions){
		this.typeOptions = typeOptions;
	}

	public void setContent(List<Content> content) {
		// TODO Auto-generated method stub
		this.content = content;
	}
}
