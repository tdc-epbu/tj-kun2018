package jp.co.tdc.epbu.tjkun.device;

public class DeviceFactory {

	private DeviceFactory() {

	}

	public static DeviceFactory getInstance() {

		if (instance == null) {
			instance = new DeviceFactory();
		}
		return instance;
	}

	private static DeviceFactory instance;

	public DrivingWheel getDrivingWheel() {
		return null;
	}

	public LightSensor getLightSensor() {
		return null;
	}

	public Tail getTail() {
		return null;
	}

	public UltrasonicSensor getUltrasonicSensor() {
		return null;
	}


	public TouchSensor getTouchSensor() {
		return null;
	}

	public BalancerControl getBalancerControl() {
		return null;
	}
}
