package test.test5;

import org.springframework.stereotype.Component;

@Component
public class Star implements Game {

	@Override
	public void on() {
		System.out.println("스타 실행");

	}

	@Override
	public void play() {
		System.out.println("스타 플레이");

	}

	@Override
	public void off() {
		System.out.println("스타 종료");

	}

}
