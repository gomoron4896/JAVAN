package com.ict.erp.vo;

public class DepartInfo {
	private Long diNum;
	private String diCode;
	private String diName;
	private String diDesc;
	private PageInfo pi;
	
	public PageInfo getPi() {
		return pi;
	}
	public void setPi(PageInfo pi) {
		this.pi = pi;
	}
	public DepartInfo() {}
	
	public DepartInfo(Long diNum, String diCode, String diName, String diDesci) {
		super();
		this.diNum = diNum;
		this.diCode = diCode;
		this.diName = diName;
		this.diDesc = diDesc;
	}
	
	public Long getDiNum() {
		return diNum;
	}
	public void setDiNum(Long diNum) {
		this.diNum = diNum;
	}
	public String getDiCode() {
		return diCode;
	}
	public void setDiCode(String diCode) {
		this.diCode = diCode;
	}
	public String getDiName() {
		return diName;
	}
	public void setDiName(String diName) {
		this.diName = diName;
	}
	public String getDiDesc() {
		return diDesc;
	}
	public void setDiDesc(String diDesc) {
		this.diDesc = diDesc;
	}
	@Override
	public String toString() {
		return "DepartInfo [diNum=" + diNum + ", diCode=" + diCode + ", diName=" + diName + ", diDesc=" + diDesc + "]";
	}
	
}
