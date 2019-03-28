package kr.co.domain;

public class Criteria {

	private int page;
	private int perpage;
	
	public Criteria() {
		// TODO Auto-generated constructor stub
		page=1;
		perpage=10;
	}

	public Criteria(int page, int perpage) {
		super();
		this.page = page;
		this.perpage = perpage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerpage() {
		return perpage;
	}

	public void setPerpage(int perpage) {
		this.perpage = perpage;
	}
	
	public int getStartNum() {
		int startNum=(page-1)*perpage+1;
		return startNum;
	}
	
	
	
}
