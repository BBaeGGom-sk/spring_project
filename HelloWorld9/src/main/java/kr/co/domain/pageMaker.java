package kr.co.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class pageMaker {

	private int amount;
	private int totalpage;
	private int beginPageNum;
	private int stopPageNum;
	private Criteria cri;
	
	public pageMaker() {
		// TODO Auto-generated constructor stub
	}

	public pageMaker(int amount, Criteria cri) {
		super();
		this.amount = amount;
		this.cri = cri;
		
		totalpage=(amount-1)/cri.getPerpage()+1;
		
		beginPageNum=((cri.getPage()-1)/10)*10+1;
		
		stopPageNum=(((cri.getPage()-1)/10)+1)*10;
		if(totalpage<stopPageNum) {
			stopPageNum=totalpage;
		} 
	}
	
	

	public pageMaker(int amount, int totalpage, int beginPageNum, int stopPageNum, Criteria cri) {
		super();
		this.amount = amount;
		this.totalpage = totalpage;
		this.beginPageNum = beginPageNum;
		this.stopPageNum = stopPageNum;
		this.cri = cri;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;

totalpage=(amount-1)/cri.getPerpage()+1;
		
		beginPageNum=((cri.getPage()-1)/10)*10+1;
		
		stopPageNum=(((cri.getPage()-1)/10)+1)*10;
		if(totalpage<stopPageNum) {
			stopPageNum=totalpage;
		} 
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getBeginPageNum() {
		return beginPageNum;
	}

	public void setBeginPageNum(int beginPageNum) {
		this.beginPageNum = beginPageNum;
	}

	public int getStopPageNum() {
		return stopPageNum;
	}

	public void setStopageNum(int stopPageNum) {
		this.stopPageNum = stopPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
	public String makeQuery(int page) {
		UriComponents uc = 
				UriComponentsBuilder
				.newInstance()
				.queryParam("page", page)
				.queryParam("perpage", cri.getPerpage())
				.build();
		
		return uc.toUriString(); // 스프링에서만 지원함 !
	}
	
	public String makeSearch(int page) {
		UriComponents uc = 
				UriComponentsBuilder
				.newInstance()
				.queryParam("page", page)
				.queryParam("perpage", cri.getPerpage())
				.queryParam("searchType", ((SearchCriteria)cri).getSearchType())
				.queryParam("keyword", ((SearchCriteria)cri).getKeyword())
				.build();
		
		return uc.toUriString(); // 스프링에서만 지원함 !
	}
}
