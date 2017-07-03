package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.EV3Control;

public class CollisionSensor {

	private static EV3Control ev3Control;

	public CollisionSensor(EV3Control ev3Control) {
		CollisionSensor.ev3Control = ev3Control;
	}

	public static boolean CollisionCheck() {
		boolean CollisionCheck = false;
		float GyroValue = ev3Control.getGyroValue();
		 /* ジャイロセンサーの値が閾値を超えたら、衝突を検知したとみなす。
		  * 現在設定している閾値は仮設定。
		  * また走行テストで誤検知をするようであれば、モーターの速度の条件を追加する。
		  */
		if (GyroValue > 0.1) { // 閾値を設定する
			CollisionCheck = true;
		} else {
			CollisionCheck = false;
		}
		return CollisionCheck;
	}

}
