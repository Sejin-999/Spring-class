package org.tukorea.di.service;

import java.util.List;

import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.persistence.MemberDAO;
import org.tukorea.di.persistence.MemberDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public StudentVO readMember(String id) throws Exception {
		return memberDAO.read(id);
	}
	
	public void addMember(StudentVO student) throws Exception {
		memberDAO.add(student);
	}
	
	public List<StudentVO> readMemberList() throws Exception{
		return memberDAO.readList();
	}

	@Override
	public void updateMember(StudentVO student) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.update(student);
	}

	@Override
	public void deleteMember(String userId) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.delete(userId);
		
	}
}
