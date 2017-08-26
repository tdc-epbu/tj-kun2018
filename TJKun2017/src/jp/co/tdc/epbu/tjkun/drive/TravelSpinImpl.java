package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;

public class TravelSpinImpl implements Travel {

	private WheelSpeed speed;

	public TravelSpinImpl(WheelSpeed speed) {
		this.speed = speed;
	}

	EV3 ev3 = EV3.getInstance();
	public void travel() {
		float forward = speed.getWheelSpeedScaleLeft();
		float turn = 50.0F;
		int tail = 0;
		ev3.controlBalance(forward, turn ,tail);
	}

}
