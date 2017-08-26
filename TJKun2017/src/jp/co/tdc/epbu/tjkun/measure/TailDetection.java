package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.DeviceFactory;
import jp.co.tdc.epbu.tjkun.device.EV3Control;

public class TailDetection implements Detection{

	private EV3Control ev3Control;
	int tailAngle = 0;


	//コンストラクタに引数を持たせる
	public TailDetection(int Angle) {
		this.tailAngle = Angle;

	}

	@Override
	public boolean Notify() {
		if (DeviceFactory.getInstance().getTail().getTailAngle() > tailAngle) { // 閾値は仮設定
			return true;
		} else {
			return false;
		}
	}

}
