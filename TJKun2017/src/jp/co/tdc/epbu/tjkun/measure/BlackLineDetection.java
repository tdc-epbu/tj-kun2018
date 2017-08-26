package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.DeviceFactory;

public class BlackLineDetection implements Detection{

	float blackLineDetection = 0;

	public BlackLineDetection(float blackline) {
		this.blackLineDetection = blackline;
	}

	@Override
	public boolean Notify() {
		if (DeviceFactory.getInstance().getLightSensor().getBrightness() < blackLineDetection) {
			return true;
		} else {
			return false;
		}
	}
}

