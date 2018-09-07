package ict.sp.test.ch2;

import org.springframework.stereotype.Service;

@Service
public class ProjectManager implements Emp {

	@Override
	public void goForWork() {
		System.out.println("플젝 관리자가 출근합니다");
		
	}

	@Override
	public void doWorking() {
		System.out.println("일하는 척 하는 중");
		
	}

	@Override
	public void goHome() {
		System.out.println("외근이라 쓰고 퇴근이라 읽는다");
		
	}

}
