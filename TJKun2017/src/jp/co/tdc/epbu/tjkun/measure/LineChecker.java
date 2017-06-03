package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.EV3Control;

public class LineChecker {

	private EV3Control ev3Control;

	public LineChecker(EV3Control ev3Control) {
		this.ev3Control = ev3Control;
	}

	public boolean lineCheck() {
		boolean lineCheck;
		 float brightness = ev3Control.getBrightness();

		if (brightness == 0) {
			lineCheck = true; // ラインチェック
		} else {
			lineCheck = false;
		}

		return lineCheck;
	}

}