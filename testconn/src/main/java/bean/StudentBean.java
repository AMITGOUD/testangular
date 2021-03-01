package bean;

import java.io.InputStream;

public class StudentBean {
	
	public InputStream getBinaryStream() {
		return binaryStream;
	}
	public void setBinaryStream(InputStream binaryStream) {
		this.binaryStream = binaryStream;
	}
	private String rollNo;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String fileToUpload;
	private InputStream binaryStream;
	public String getFileToUpload() {
		return fileToUpload;
	}
	public void setFileToUpload(String fileToUpload) {
		this.fileToUpload = fileToUpload;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

}
