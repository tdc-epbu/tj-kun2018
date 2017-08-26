package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.BalancerControl;
import jp.co.tdc.epbu.tjkun.device.DeviceFactory;

public class TravelSpinImpl implements Travel {

	private WheelSpeed speed;
	private int tailAngle;

    private BalancerControl balancerControl;

	public TravelSpinImpl(WheelSpeed speed, int tailAngle) {
		this.speed = speed;
		this.tailAngle = tailAngle;

		balancerControl = DeviceFactory.getInstance().getBalancerControl();
	}

	public void travel() {
		float forward = speed.getWheelSpeedScaleLeft();
		float turn = 50.0F;
		int tail = 0;
		balancerControl.controlBalance(forward, turn ,tail);
	}

}
