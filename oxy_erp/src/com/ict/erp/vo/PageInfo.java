package com.ict.erp.vo;

public class PageInfo {
	private int sNum;
	private int lNum;
	private int page = 10;
	private int block = 10;
	private int totalPage;
	private int totalCnt;
	
	
	public PageInfo() {
		super();
	}	
			
	public PageInfo(int sNum, int lNum, int page, int block, int totalPage, int totalCnt) {
		super();
		this.sNum = sNum;
		this.lNum = lNum;
		this.page = page;
		this.block = block;
		this.totalPage = totalPage;
		this.totalCnt = totalCnt;
	}

	public int getsNum() {
		return sNum;
	}

	public void setsNum(int sNum) {
		this.sNum = sNum;
	}

	public int getlNum() {
		return lNum;
	}

	public void setlNum(int lNum) {
		this.lNum = lNum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	@Override
	public String toString() {
		return "PageInfo [sNum=" + sNum + ", lNum=" + lNum + ", page=" + page + ", block=" + block + ", totalPage="
				+ totalPage + ", totalCnt=" + totalCnt + "]";
	}

}
