package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;

public class TravelBalanceImpl implements Travel {

	EV3 ev3 = EV3.getInstance();

	public void travel(WheelSpeed speed,int tail) {
		float forward = speed.getWheelSpeedScaleLeft();
		float turn = speed.getTurnSpeedScale();
		ev3.controlBalance(forward, turn, tail);
	}

}
