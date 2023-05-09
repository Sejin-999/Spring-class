
package org.tukorea.di.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import org.tukorea.di.service.MemberServiceImpl;
public class MemberSampleMain {

	private static ApplicationContext ctx = null;
	static Scanner scan = new Scanner(System.in);


	public static void main(String[] args) throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		MemberService memberService = ctx.getBean(MemberService.class);  // by Class name
		StudentVO newStudent = new StudentVO(); 
		
		
		while(true) {
			System.out.println("----------------------------------------------------");
			System.out.println("	학생   정보   관리   프로그램		");
			System.out.println("----------------------------------------------------");
			System.out.println("1. 전체 학생 정보 출력");
			System.out.println("2. 개인 학생 정보 출력");
			System.out.println("3. 개인 학생 정보 생성");
			System.out.println("4. 개인 학생 정보 삭제");
			System.out.println("5. 개인 학생 정보 수정");
			System.out.println("6. 프로그램 종료");
			System.out.println("----------------------------------------------------");
			System.out.print("SELECT >> ");
			try {
				String input;
				int sel = scan.nextInt();		
				scan.nextLine();
				
				switch(sel) {
				case 1:
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
					break;
				case 2:
					System.out.print("Please enter your ID >> ");
					String strID = scan.next();
					StudentVO member = memberService.readMember(strID);
					System.out.println("----------------------------------------------------");
					System.out.println("id			:	"+member.getId());
					System.out.println("passwd			:	"+member.getPasswd());
					System.out.println("username		:	"+member.getUsername());
					System.out.println("snum			:	"+member.getSnum());
					System.out.println("depart			:	"+member.getDepart());
					System.out.println("mobile			:	"+member.getMobile());
					System.out.println("email			:	"+member.getEmail());	
					break;
				case 3:
					System.out.println("new Student ");
					
					
					System.out.print("id "); input = scan.next(); newStudent.setId(input);
					System.out.print("passwd "); input = scan.next(); newStudent.setPasswd(input);
					System.out.print("username "); input = scan.next(); newStudent.setUsername(input);
					System.out.print("snum "); input = scan.next(); newStudent.setSnum(input);
					System.out.print("depart "); input = scan.next(); newStudent.setDepart(input);
					System.out.print("mobile "); input = scan.next(); newStudent.setMobile(input);
					System.out.print("email "); input = scan.next(); newStudent.setEmail(input);
					memberService.addMember(newStudent);
					System.out.println("Successful creation of new student !!!");
					break;
				case 4:
					System.out.println("delete Student >> please enter your id >> ");
					input = scan.next();
					memberService.deleteMember(input);
					break;
				case 5:
					System.out.println("update Student >> please enter your id >> ");
					input = scan.next(); newStudent.setId(input);
					System.out.println("update Student >> Infomain");
					System.out.print("passwd "); input = scan.next(); newStudent.setPasswd(input);
					System.out.print("username "); input = scan.next(); newStudent.setUsername(input);
					System.out.print("snum "); input = scan.next(); newStudent.setSnum(input);
					System.out.print("depart "); input = scan.next(); newStudent.setDepart(input);
					System.out.print("mobile "); input = scan.next(); newStudent.setMobile(input);
					System.out.print("email "); input = scan.next(); newStudent.setEmail(input);
					memberService.updateMember(newStudent);
					break;
				case 6:
					System.out.println("안녕히가세요!");
					System.exit(0);
				}
			}catch(InputMismatchException e){
				System.out.println("확인 후 입력하세요.");
				continue;
			}
		}
	}

}
