package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.DeviceFactory;
import jp.co.tdc.epbu.tjkun.device.DirectControl;
import lejos.utility.Delay;

public class TravelTailDownImpl implements Travel {

    private DirectControl directControl;


	int tail_up = 65;
	int tail_down = 90;
	int state = tail_down;
	private WheelSpeed speed;

	public TravelTailDownImpl(WheelSpeed speed) {
		this.speed = speed;

		directControl = DeviceFactory.getInstance().getDirectControl();
	}

	public void travel() {
		int tail_up = 66;
		int tail_down = 90;

//		if(state ==  tail_down) {
////			ev3.controlBalance(0, 0, state);
//			state--;
//			return;
//		}
//
//		if(state-1 ==  tail_down) {
//			ev3.controlDirect(10, 10, state) ;
//			state--;
//			return;
//		}

		directControl.controlDirect(0, 0, state) ;
		Delay.msDelay(100);
		if(state >= tail_up ) {
			state--;
		}


	}
}
