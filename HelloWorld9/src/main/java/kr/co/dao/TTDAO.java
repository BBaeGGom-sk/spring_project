package kr.co.dao;

import java.util.List;

import kr.co.domain.TTDTO;
import kr.co.domain.TestDTO;

public interface TTDAO {

	public void insert(TTDTO dto);

	public List<TTDTO> list();

	public TTDTO selectbyid(int num);
	
}
