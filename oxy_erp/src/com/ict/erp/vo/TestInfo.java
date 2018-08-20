package com.ict.erp.vo;

public class TestInfo {
	private int tiNum;
	private String tiName;
	private String tiText;
	private String tiId;

	public TestInfo(int tiNum, String tiName, String tiText, String tiId) {
		super();
		this.tiNum = tiNum;
		this.tiName = tiName;
		this.tiText = tiText;
		this.tiId = tiId;
	}
	
	public TestInfo() {
		super();
	}

	public int getTiNum() {
		return tiNum;
	}

	public void setTiNum(int tiNum) {
		this.tiNum = tiNum;
	}

	public String getTiName() {
		return tiName;
	}

	public void setTiName(String tiName) {
		this.tiName = tiName;
	}

	public String getTiText() {
		return tiText;
	}

	public void setTiText(String tiText) {
		this.tiText = tiText;
	}

	public String getTiId() {
		return tiId;
	}

	public void setTiId(String tiId) {
		this.tiId = tiId;
	}

	@Override
	public String toString() {
		return "TestInfo [tiNum=" + tiNum + ", tiName=" + tiName + ", tiText=" + tiText + ", tiId=" + tiId + "]";
	}

}
