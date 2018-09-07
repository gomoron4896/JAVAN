package ict.sp.test.ch2;

import org.springframework.stereotype.Service;

@Service
public class Developer implements Emp {

	@Override
	public void goForWork() {
		System.out.println("개발자가 출근합니다");
		
	}

	@Override
	public void doWorking() {
		System.out.println("개발자가 일합니다");
		
	}

	@Override
	public void goHome() {
		System.out.println("퇴근했는데 12시");
		
	}

}
