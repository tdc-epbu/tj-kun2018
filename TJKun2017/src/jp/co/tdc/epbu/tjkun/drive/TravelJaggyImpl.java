package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.BalancerControl;
import jp.co.tdc.epbu.tjkun.device.DeviceFactory;
import jp.co.tdc.epbu.tjkun.device.LightSensor;
import jp.co.tdc.epbu.tjkun.measure.Calibrater;

public class TravelJaggyImpl implements Travel {


	private LightSensor lightSensor;
	private BalancerControl balancerControl;


	private static final float LIGHT_WHITE = 0.50F; // 白色のカラーセンサー輝度値
	private static final float LIGHT_BLACK = 0.02F; // 黒色のカラーセンサー輝度値
	private WheelSpeed speed;
	private int tailAngle;
	// private static final float THRESHOLD = (LIGHT_WHITE+LIGHT_BLACK)/2.0F; //
	// ライントレースの閾値

	private float THRESHOLD;

	public TravelJaggyImpl(WheelSpeed speed,int tailAngle) {
		this.speed = speed;
		this.tailAngle = tailAngle;

		DeviceFactory df = DeviceFactory.getInstance();

		lightSensor = df.getLightSensor();
		balancerControl = df.getBalancerControl();

		Calibrater calibrater = Calibrater.getInstance();
		this.THRESHOLD = (calibrater.blackBaseline() + calibrater.whiteBaseline()) / 2.0F;

	}

	public void travel() {
		float forward = speed.getWheelSpeedScaleLeft();
		float turn = jaggyTravel();
		int tail = 0;
		balancerControl.controlBalance(forward, turn, tail);
	}

	/**
	 * ジグザグ走行制御
	 */
	public float jaggyTravel() {
		if (lightSensor.getBrightness() > THRESHOLD) {
			return 50.0F; // 右旋回命令
		} else {
			return -50.0F; // 左旋回命令
		}
	}

}
