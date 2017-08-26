package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;

public class TravelTailUpImpl implements Travel {
	EV3 ev3 = EV3.getInstance();

	private WheelSpeed speed;

	public TravelTailUpImpl(WheelSpeed speed) {
		this.speed = speed;
	}

	public void travel() {
		int tail_up = 66;
		int tail_down = 90;
		for (int i = tail_up; i >= tail_down; i++) {
			ev3.controlDirect(0, 0, i) ;
		}
		ev3.controlBalance(-10, 0, 0);
	}

}
