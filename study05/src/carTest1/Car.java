package carTest1;

public abstract class Car {

	public abstract void drive();
	public abstract void stop();
	
	void startCar() {
		System.out.println("시동을 킵니다.");
	}
	
	void turnoff() {
		System.out.println("시동을 끕니다.");
	}
	final void run() {
		startCar();
		drive();
		stop();
		turnoff();
	}

}
