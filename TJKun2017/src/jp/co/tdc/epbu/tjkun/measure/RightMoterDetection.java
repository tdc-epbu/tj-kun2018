package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.DeviceFactory;

public class RightMoterDetection implements Detection{

	int rightMoterDetection = 0;

	public RightMoterDetection(int rightMoter) {
		this.rightMoterDetection = rightMoter;
	}

	@Override
	public boolean Notify() {
		if (DeviceFactory.getInstance().getDrivingWheel().getRMotorCount() > rightMoterDetection) {
			return true;
		} else {
			return false;
		}
	}
}

