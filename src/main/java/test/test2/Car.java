package test.test2;

import lombok.Data;

@Data
public class Car {
	private String carName;
	private Integer price;
	public Car(String carName) {
		this.carName = carName;
	}
}
