package test.test1;

import lombok.Data;

@Data
public class Human {
	public Human() {
		System.out.println("난 언제 생성될까?");
	}
	private String name;
	private Integer age;
}
