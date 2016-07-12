package com.esgi.scheduler.mail.utils;

public class Config {
	
	private String mailsmtphost;
	private String mailsmtpport;
	private String mailfrom;
	private String mailsubject;
	private String mailmessage;
	private String mailto;
	private String mailcc;
			
	public Config(){}
	
	public Config(String properties){
		Utils utils = new Utils(properties);
		setMailfrom(utils.getProperty("mail.from"));
		setMailmessage(utils.getProperty("mail.message"));
		setMailsmtphost(utils.getProperty("mail.smtp.host"));
		setMailsmtpport(utils.getProperty("mail.smtp.port"));
		setMailsubject(utils.getProperty("mail.subject"));
		setMailto(utils.getProperty("mail.to"));
		setMailcc(utils.getProperty("mail.cc"));
	}

	public String getMailsmtphost() {
		return mailsmtphost;
	}

	public void setMailsmtphost(String mailsmtphost) {
		this.mailsmtphost = mailsmtphost;
	}

	public String getMailsmtpport() {
		return mailsmtpport;
	}

	public void setMailsmtpport(String mailsmtpport) {
		this.mailsmtpport = mailsmtpport;
	}

	public String getMailsubject() {
		return mailsubject;
	}

	public void setMailsubject(String mailsubject) {
		this.mailsubject = mailsubject;
	}

	public String getMailmessage() {
		return mailmessage;
	}

	public void setMailmessage(String mailmessage) {
		this.mailmessage = mailmessage;
	}

	public String getMailfrom() {
		return mailfrom;
	}

	public void setMailfrom(String mailfrom) {
		this.mailfrom = mailfrom;
	}

	public String getMailto() {
		return mailto;
	}

	public void setMailto(String mailto) {
		this.mailto = mailto;
	}

	public String getMailcc() {
		return mailcc;
	}

	public void setMailcc(String mailcc) {
		this.mailcc = mailcc;
	}

}
