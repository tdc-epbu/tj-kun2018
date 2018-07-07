package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.EV3Control;

public class LineDetection implements Detection{

	private EV3Control ev3Control;
	public LineDetection(EV3Control ev3Control) {
		this.ev3Control = ev3Control;
	}

	@Override
	public boolean Notify() {
		if (ev3Control.getBrightness() < 0.1) { // 閾値は仮設定
			return true;
		} else {
			return false;
		}
	}
}

