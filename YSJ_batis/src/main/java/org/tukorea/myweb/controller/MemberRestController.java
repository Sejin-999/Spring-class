package org.tukorea.myweb.controller;

import java.lang.System.Logger;

import java.nio.charset.Charset;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tukorea.myweb.domain.StudentVO;
import org.tukorea.myweb.service.MemberService;

@RestController
@RequestMapping("/member/rest")
public class MemberRestController {

	@Autowired(required=true)
    private MemberService memberService;

	
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentVO> readMember(@PathVariable String id) throws Exception {
    	StudentVO student = memberService.readMember(id);
    	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		headers.set("My-Header", "MyHeaderValue");
		return new ResponseEntity<StudentVO>(student, headers, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
	public String createMemberPost( @RequestBody StudentVO vo) throws Exception {
		memberService.addMember(vo);
		return "OK";
	}

}
