package jp.co.tdc.epbu.tjkun.device;

public class DeviceFactory {

    private EV3Control ev3;

	private DeviceFactory() {

	    ev3 = EV3.getInstance();
	}

	public static DeviceFactory getInstance() {

		if (instance == null) {
			instance = new DeviceFactory();
		}
		return instance;
	}

	private static DeviceFactory instance;

	public DrivingWheel getDrivingWheel() {
		return ev3;
	}

	public LightSensor getLightSensor() {
		return ev3;
	}

	public Tail getTail() {
		return ev3;
	}

	public UltrasonicSensor getUltrasonicSensor() {
		return ev3;
	}


	public TouchSensor getTouchSensor() {
		return ev3;
	}

	public BalancerControl getBalancerControl() {
		return ev3;
	}
}
