package jp.co.tdc.epbu.tjkun.device;

public interface GyroSensor {
	/**
	 * ジャイロセンサーから角速度を取得する。
	 *
	 * @return 角速度。
	 */
	 float getGyroValue();
}
