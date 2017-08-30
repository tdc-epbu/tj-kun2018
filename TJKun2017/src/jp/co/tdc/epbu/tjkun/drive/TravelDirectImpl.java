package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.DeviceFactory;
import jp.co.tdc.epbu.tjkun.device.DirectControl;

public class TravelDirectImpl implements Travel {

	private DirectControl directControl;

	private WheelSpeed speed;
	private int tailAngle;

	public TravelDirectImpl(WheelSpeed speed, int tailAngle) {
		this.speed = speed;
		this.tailAngle = tailAngle;

		directControl = DeviceFactory.getInstance().getDirectControl();
	}

	public void travel() {
		int left = speed.getWheelSpeedScaleLeft();
		int right = speed.getWheelSpeedScaleRight();
		directControl.controlDirect(left, right, tailAngle);

	}
}
