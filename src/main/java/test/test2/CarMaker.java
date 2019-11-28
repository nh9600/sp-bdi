package test.test2;

public class CarMaker {
	private String carMakerName;
	private Car car;

	public CarMaker(String carMakerName) {
		this.carMakerName = carMakerName;
	}

	public void setCar(Car car) {
		System.out.println(this.carMakerName + "가 차를 만듭니다.");
		this.car = car;
	}
	public Car makeCar() {
		return this.car;
	}
	
	@Override
	public String toString() {
		return "CarMaker [carMakerName=" + carMakerName + ", car=" + car + "]";
	}

}
