package kr.co.service;

import java.util.List;

import kr.co.domain.TTDTO;

public interface TTService {

	public void insert(TTDTO dto);

	public List<TTDTO> list();

	public TTDTO selectbyid(int num);
	
}
