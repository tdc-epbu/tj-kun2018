package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.BalancerControl;
import jp.co.tdc.epbu.tjkun.device.DeviceFactory;
import jp.co.tdc.epbu.tjkun.device.DirectControl;

public class TravelTailUpImpl implements Travel {

    private DirectControl directControl;
    private BalancerControl balancerControl;

	private WheelSpeed speed;
	private int tailAngle;

	public TravelTailUpImpl(WheelSpeed speed, int tailAngle) {


	       DeviceFactory df = DeviceFactory.getInstance();

	       directControl = df.getDirectControl();
	        balancerControl = df.getBalancerControl();

		this.speed = speed;
		this.tailAngle = tailAngle;
	}

	public void travel() {
		int tail_up = 66;
		int tail_down = 90;
		for (int i = tail_up; i >= tail_down; i++) {
		    directControl.controlDirect(0, 0, i) ;
		}
		balancerControl.controlBalance(-10, 0, 0);
	}

}
