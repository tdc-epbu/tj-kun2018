package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;

public class TravelDirectImpl implements Travel {
	EV3 ev3 = EV3.getInstance();

	public void travel(WheelSpeed speed,int tail) {
		ev3.controlDirect(speed.wheelSpeedScaleLeft, speed.getWheelSpeedScaleRight(), tail) ;
	}
}
