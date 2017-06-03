package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.EV3Control;

public class ObstaclesDetection implements Detection{

	private EV3Control ev3Control;
	public ObstaclesDetection(EV3Control ev3Control) {
		this.ev3Control = ev3Control;
	}

	@Override
	public boolean Notify() {
		if (ev3Control.getSonarDistance() < 0.3) { // 閾値は仮設定
			return true;
		} else {
			return false;
		}
	}
}

