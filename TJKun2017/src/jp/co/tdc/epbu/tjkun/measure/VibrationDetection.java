package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.DeviceFactory;

public class VibrationDetection implements Detection{

	float vibrationDetection = 0;

	public VibrationDetection(float vibration) {
		this.vibrationDetection = vibration;
	}

	@Override
	public boolean Notify() {
		// ジャイロセンサーから値を取得する
		if (DeviceFactory.getInstance().getGyroSensor().getGyroValue() > vibrationDetection) {
			return true;
		} else {
			return false;
		}
	}
}

