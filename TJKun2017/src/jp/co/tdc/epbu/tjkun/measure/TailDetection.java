package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.DeviceFactory;

public class TailDetection implements Detection{

	int tailAngle = 0;


	public TailDetection(int angle) {
		this.tailAngle = angle;

	}

	@Override
	public boolean Notify() {
		if (DeviceFactory.getInstance().getTail().getTailAngle() > tailAngle) {
			return true;
		} else {
			return false;
		}
	}

}
