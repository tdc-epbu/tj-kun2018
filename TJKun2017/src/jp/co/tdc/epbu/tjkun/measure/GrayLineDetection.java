package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.DeviceFactory;

public class GrayLineDetection implements Detection {

	static int grayCount;
	float grayLineDetection = 0;

	public GrayLineDetection(float grayLine) {
		this.grayLineDetection = grayLine;
	}

	@Override
	public boolean Notify() {
		 /* 通常走行時の誤検知を防ぐために、
		  * 灰色マーカー輝度値が一定回数検知されたら灰色を検知したとみなす
		  */
			if (DeviceFactory.getInstance().getLightSensor().getBrightness() > grayLineDetection) {
				grayCount++;
			} else {
				grayCount = 0;
				return false;
			}
			if (grayCount > 4){
				return true;
			} else {
				return false;
			}
	}
}