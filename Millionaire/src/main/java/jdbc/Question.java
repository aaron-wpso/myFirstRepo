package jdbc;

import java.util.ArrayList;

public class Question 
{
	int qID;
	String qContent;
    String caContent;
    String wa1Content; 
    String wa2Content;
    String wa3Content;
    ArrayList<String> wrongAnswers;
    
    public Question(int qID, String qContent, String caContent, String wa1Content, String wa2Content, String wa3Content)
    {
    	this.qID = qID;
    	this.qContent = qContent;
    	this.caContent = caContent;
    	this.wa1Content = wa1Content;
    	this.wa2Content = wa2Content;
    	this.wa3Content = wa3Content;
    	wrongAnswers = new ArrayList<String>();
    	wrongAnswers.add(this.wa1Content);
    	wrongAnswers.add(this.wa2Content);
    	wrongAnswers.add(this.wa3Content);
    }

	public int getqID() {
		return qID;
	}

	public void setqID(int qID) {
		this.qID = qID;
	}

	public String getqContent() {
		return qContent;
	}

	public void setqContent(String qContent) {
		this.qContent = qContent;
	}

	public String getCaContent() {
		return caContent;
	}

	public void setCaContent(String caContent) {
		this.caContent = caContent;
	}

	public String getWa1Content() {
		return wa1Content;
	}

	public void setWa1Content(String wa1Content) {
		this.wa1Content = wa1Content;
	}

	public String getWa2Content() {
		return wa2Content;
	}

	public void setWa2Content(String wa2Content) {
		this.wa2Content = wa2Content;
	}

	public String getWa3Content() {
		return wa3Content;
	}

	public void setWa3Content(String wa3Content) {
		this.wa3Content = wa3Content;
	}
	
	public ArrayList<String> getWrongAnswers()
	{
		return wrongAnswers;
	}
	/*public String toString() 
	{
		return "{ " + getqContent() + ", " + getCaContent() + ", " + getWa1Content() + ", " + getWa2Content() + ", " + getWa3Content() + " }";
	}*/
    
}
