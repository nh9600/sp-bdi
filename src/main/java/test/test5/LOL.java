package test.test5;

import org.springframework.stereotype.Component;

@Component
public class LOL implements Game {

	@Override
	public void on() {
		System.out.println("롤 실행");

	}

	@Override
	public void play() {
		System.out.println("롤 플레이");

	}

	@Override
	public void off() {
		System.out.println("롤 종료");

	}

}
