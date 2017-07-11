package test.coreapi;

import java.util.List;

public class PollInfo {
	
	private int expiration;
	private int isimage;
	private List<Item> item;
	private int maxchoices;
	private int multiple;
	private String pollpreview;
	private int visible;
	
	public int getExpiration(){
		return expiration;
	}
	
	public void setExpiration(int expiration){
		this.expiration = expiration;
	}
	
	public int getIsimage(){
		return isimage;
	}
	
	public void setIsImage(int isimage){
		this.isimage = isimage;
	}
	
	public List<Item> getItem(List<Item> item){
		return item;
	}
	
	public void setItem(List<Item> item){
		this.item = item;
	}
	
	public int getMaxchoices(){
		return maxchoices;
	}
	
	public void setMaxchoices(int maxchoices){
		this.maxchoices = maxchoices;
	}
	
	public int getMultiple(){
		return multiple;
	}
	
	public void setMultiple(int multiple){
		this.multiple = multiple;
	}

	public String getPollPreview(){
		return pollpreview;
	}
	
	public void setPollPreview(String pollpreview){
		this.pollpreview = pollpreview;
	}
	
	public int getVisible(){
		return visible;
	}
	
	public void setVisible(int visible){
		this.visible = visible;
	}
}
