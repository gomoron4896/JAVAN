package com.ict.music.vo;

public class FavInfo {
	private Long mcNum;
	private String mcName;
	private String mcSinger;
	private String mcVendor;
	private Long mcLike;
	private Long mcDisLike;
	private String mcCreDat;
	private String mcDesc;

	public FavInfo(Long mcNum, String mcName, String mcSinger, String mcVendor, Long mcLike, Long mcDisLike,
			String mcCreDat, String mcDesc) {
		super();
		this.mcNum = mcNum;
		this.mcName = mcName;
		this.mcSinger = mcSinger;
		this.mcVendor = mcVendor;
		this.mcLike = mcLike;
		this.mcDisLike = mcDisLike;
		this.mcCreDat = mcCreDat;
		this.mcDesc = mcDesc;
	}

	public Long getMcNum() {
		return mcNum;
	}

	public void setMcNum(Long mcNum) {
		this.mcNum = mcNum;
	}

	public String getMcName() {
		return mcName;
	}

	public void setMcName(String mcName) {
		this.mcName = mcName;
	}

	public String getMcSinger() {
		return mcSinger;
	}

	public void setMcSinger(String mcSinger) {
		this.mcSinger = mcSinger;
	}

	public String getMcVendor() {
		return mcVendor;
	}

	public void setMcVendor(String mcVendor) {
		this.mcVendor = mcVendor;
	}

	public Long getMcLike() {
		return mcLike;
	}

	public void setMcLike(Long mcLike) {
		this.mcLike = mcLike;
	}

	public Long getMcDisLike() {
		return mcDisLike;
	}

	public void setMcDisLike(Long mcDisLike) {
		this.mcDisLike = mcDisLike;
	}

	public String getMcCreDat() {
		return mcCreDat;
	}

	public void setMcCreDat(String mcCreDat) {
		this.mcCreDat = mcCreDat;
	}

	public String getMcDesc() {
		return mcDesc;
	}

	public void setMcDesc(String mcDesc) {
		this.mcDesc = mcDesc;
	}

	@Override
	public String toString() {
		return "FavInfo [mcNum=" + mcNum + ", mcName=" + mcName + ", mcSinger=" + mcSinger + ", mcVendor=" + mcVendor
				+ ", mcLike=" + mcLike + ", mcDisLike=" + mcDisLike + ", mcCreDat=" + mcCreDat + ", mcDesc=" + mcDesc
				+ "]";
	}

}
