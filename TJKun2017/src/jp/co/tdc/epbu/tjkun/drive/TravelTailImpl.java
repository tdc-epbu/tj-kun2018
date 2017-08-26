package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.DeviceFactory;
import jp.co.tdc.epbu.tjkun.device.DirectControl;
import jp.co.tdc.epbu.tjkun.device.LightSensor;
import jp.co.tdc.epbu.tjkun.measure.Calibrater;

public class TravelTailImpl implements Travel {

    private DirectControl directControl;
    private LightSensor lightSensor;


	//private float THRESHOLD;
	private Calibrater calibrater;
	private WheelSpeed speed;
	private int tailAngle;

	public TravelTailImpl(WheelSpeed speed, int tailAngle) {

        DeviceFactory df = DeviceFactory.getInstance();

        lightSensor = df.getLightSensor();
        directControl = df.getDirectControl();

		this.speed = speed;
		//this.THRESHOLD = (calibrater.blackBaseline() + calibrater.whiteBaseline() * 2) / 3.0F;
		this.calibrater = Calibrater.getInstance();
		this.tailAngle = tailAngle;
	}

	public float getBrightnessValue() {

		float temp = lightSensor.getBrightness();

		//LCD.drawString(Float.toString(temp), 0, 1);

		return (((temp - calibrater.blackBaseline()) / (calibrater.whiteBaseline() - calibrater.blackBaseline()))
				* 100.0f);
	}

	public void travel() {
//
//		int left;
//		int right;
//
//		if (getBrightnessValue() > 80) {
//			left = speed.getWheelSpeedScaleLeft();
//			right = speed.getWheelSpeedScaleRight();
//		}else{
//			left = speed.getWheelSpeedScaleRight();
//			right = speed.getWheelSpeedScaleLeft();
//		}
		int left = speed.getWheelSpeedScaleLeft();
		int right = speed.getWheelSpeedScaleRight();

		directControl.controlDirect(left, right, tailAngle) ;
	}

}
