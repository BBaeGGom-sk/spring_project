package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberDAO dao;
	
	@Override
	public void insert(MemberDTO dto) {
		// TODO Auto-generated method stub
		dao.insert(dto);
	}

	@Override
	public List<MemberDTO> select() {
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public MemberDTO selectById(int id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	@Override
	public MemberDTO updateui(int id) {
		// TODO Auto-generated method stub
		return dao.updateui(id);
	}

	@Override
	public void update(MemberDTO dto) {
		// TODO Auto-generated method stub
		dao.update(dto);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

}
