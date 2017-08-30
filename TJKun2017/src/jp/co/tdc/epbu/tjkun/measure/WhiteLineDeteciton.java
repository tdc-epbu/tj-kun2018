package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.DeviceFactory;

public class WhiteLineDeteciton implements Detection {

	static int whiteDurationTime = SectionRunActual.getInstance().getTime();
	float whiteLineDeteciton = 0;


	public WhiteLineDeteciton(int whiteduration) {
		this.whiteLineDeteciton = whiteduration;
	}

	@Override
	public boolean Notify() {
		 /* あらかじめ取得していた計測時間と白色を検知した
		  *
		  */
		if (DeviceFactory.getInstance().getLightSensor().getBrightness() > whiteLineDeteciton) {
			if (SectionRunActual.getInstance().getTime() > whiteDurationTime) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
