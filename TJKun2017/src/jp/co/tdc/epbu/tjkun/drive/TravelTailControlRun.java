package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;

public class TravelTailControlRun implements Travel {


	EV3 ev3 = EV3.getInstance();
	public int tail;
	private float THRESHOLD;
	private WheelSpeed speed;

	public TravelTailControlRun(WheelSpeed speed, int tail) {
		this.speed = speed;

		this.THRESHOLD = (calibrater.blackBaseline() + calibrater.whiteBaseline()) / 2.0F;
		this.tail = tail;

	}

	public void travel() {
		float forward = speed.getWheelSpeedScaleLeft();
		float turn = jaggyTravel();
		ev3.controlBalance(forward, turn, tail);
	}

	/**
	 * ジグザグ走行制御
	 */
	public float jaggyTravel() {
		if (ev3.getBrightness() > THRESHOLD) {
			return 20.0F; // 右旋回命令
		} else {
			return -20.0F; // 左旋回命令
		}
	}

}
