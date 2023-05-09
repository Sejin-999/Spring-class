package org.tukorea.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")

public class MemberTest {
	
	@Autowired
	MemberService memberService;

	@Test
	public void testReadALL( ) throws Exception {
		List<StudentVO> list = memberService.readMemberList();
		for(StudentVO svo : list) {
			System.out.println("----------------------------------------------------");
			System.out.println("id			:	"+svo.getId());
			System.out.println("passwd			:	"+svo.getPasswd());
			System.out.println("username		:	"+svo.getUsername());
			System.out.println("snum			:	"+svo.getSnum());
			System.out.println("depart			:	"+svo.getDepart());
			System.out.println("mobile			:	"+svo.getMobile());
			System.out.println("email			:	"+svo.getEmail());		
		}
	}
	
	
	@Test
	public void testDelete( ) throws Exception {
		StudentVO newStudent = new StudentVO(); 
		//add test student
		System.out.print("id ");  newStudent.setId("TEST");
		System.out.print("passwd "); newStudent.setPasswd("TEST");
		System.out.print("username ");newStudent.setUsername("TEST");
		System.out.print("snum "); newStudent.setSnum("TEST");
		System.out.print("depart "); newStudent.setDepart("TEST");
		System.out.print("mobile "); newStudent.setMobile("TEST");
		System.out.print("email "); newStudent.setEmail("TEST");
		memberService.addMember(newStudent);
		System.out.println("TEST MEMBER CREATE SUCCESSFUL");
		
		System.out.println("TEST MEMBER DELETE ----- start");
		memberService.deleteMember("TEST");
		
		System.out.println("TEST MEMBER DELETE SUCCESSFUL");
		
	}	
	
	@Test
	public void testUpdate( ) throws Exception {
		StudentVO newStudent = new StudentVO(); 
		//add test student
		System.out.print("id ");  newStudent.setId("TEST");
		System.out.print("passwd "); newStudent.setPasswd("TEST");
		System.out.print("username ");newStudent.setUsername("TEST");
		System.out.print("snum "); newStudent.setSnum("TEST");
		System.out.print("depart "); newStudent.setDepart("TEST");
		System.out.print("mobile "); newStudent.setMobile("TEST");
		System.out.print("email "); newStudent.setEmail("TEST");
		memberService.addMember(newStudent);
		
		System.out.println("TEST MEMBER CREATE SUCCESSFUL");
		
		System.out.println("TEST MEMBER UPDATE ----- start");
		System.out.print("id ");  newStudent.setId("TESTUP");
		System.out.print("passwd "); newStudent.setPasswd("TESTUP");
		System.out.print("username ");newStudent.setUsername("TESTUP");
		System.out.print("snum "); newStudent.setSnum("TESTUP");
		System.out.print("depart "); newStudent.setDepart("TESTUP");
		System.out.print("mobile "); newStudent.setMobile("TESTUP");
		System.out.print("email "); newStudent.setEmail("TESTUP");
		
		memberService.updateMember(newStudent);
		System.out.println("TEST MEMBER UPDATE SUCCESSFUL");
		
		
		System.out.println("TEST MEMBER DELETE ----- start");
		memberService.deleteMember("TESTUP");
		
		System.out.println("TEST MEMBER DELETE SUCCESSFUL");
		
	}
	
	
}
