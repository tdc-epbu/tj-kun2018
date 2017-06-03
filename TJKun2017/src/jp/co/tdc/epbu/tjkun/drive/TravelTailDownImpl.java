package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;
import jp.co.tdc.epbu.tjkun.measure.Calibrater;
import lejos.utility.Delay;

public class TravelTailDownImpl implements Travel {
	EV3 ev3 = EV3.getInstance();

	
	int tail_up = 65;
	int tail_down = 90;
	int state = tail_down;
	
	public TravelTailDownImpl(Calibrater calibrater) {
	}

	public void travel(WheelSpeed speed) {
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

		ev3.controlDirect(0, 0, state) ;
		Delay.msDelay(100);
		if(state >= tail_up ) {
			state--;
		}


	}
}
