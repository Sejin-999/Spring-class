package org.tukorea.di.main;

import org.tukorea.di.config.JavaConfig;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionSampleMain {
	
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요 TRANSACTION-MYBATIS");
	
//		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext_annotation.xml");
//		ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		MemberService memberService = ctx.getBean(MemberService.class);  // by Class name
		
		String strID1 = "TEST";
		StudentVO vo1 = new StudentVO(); 
		vo1.setId(strID1); vo1.setPasswd(strID1);  vo1.setSnum(strID1);
		vo1.setUsername("가나다라마바사자차카타파하가나다라마바사자차카타파하가나다라마바사자차카타파하가나다라마바사자차카타파하가나다라마바사자차카타파하가나다라마바사자차카타파하");
		
		String strID2 = "TEST2";
		StudentVO vo2 = new StudentVO();
		vo2.setId(strID2); vo2.setPasswd(strID2);  vo2.setSnum(strID2);
		vo2.setUsername(strID2);
		
		try {
			memberService.updateMemberList(vo1, vo2);
			System.out.println("TRANSACTION 처리 완료");
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
