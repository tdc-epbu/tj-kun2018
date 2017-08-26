package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.DeviceFactory;

public class LeftMoterDetection implements Detection{

	int leftMoterDetection = 0;

	public LeftMoterDetection(int leftMoter) {
		this.leftMoterDetection = leftMoter;
	}

	@Override
	public boolean Notify() {
		if (DeviceFactory.getInstance().getDrivingWheel().getLMotorCount() > leftMoterDetection) {
			return true;
		} else {
			return false;
		}
	}
}

