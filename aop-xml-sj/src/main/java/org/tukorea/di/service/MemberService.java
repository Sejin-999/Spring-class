package org.tukorea.di.service;

import org.tukorea.di.domain.StudentVO;

public interface MemberService {
		public StudentVO readMember(String id) throws Exception;
		public void addMember(StudentVO student) throws Exception;
}
