/**
 *
 */
package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.BalancerControl;
import jp.co.tdc.epbu.tjkun.device.DeviceFactory;

/**
 * @author kakuta
 *
 */
public class TravelBalanceImpl implements Travel  {

	private BalancerControl balancerControl;
	private WheelSpeed speed;
	private int tailAngle;

	public TravelBalanceImpl(WheelSpeed speed,int tailAngle) {
		this.speed = speed;
		this.tailAngle = tailAngle;

		DeviceFactory df = DeviceFactory.getInstance();
		balancerControl = df.getBalancerControl();
	}

	public void travel() {
		float forward = speed.getWheelSpeedScaleLeft();
		float turn = speed.getTurnSpeedScale();
		balancerControl.controlBalance(forward, turn, tailAngle);
	}


}
