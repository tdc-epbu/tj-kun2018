package jp.co.tdc.epbu.tjkun.device;

public interface LightSensor {

	/**
	 * カラーセンサーから輝度値を取得する。
	 *
	 * @return 輝度値。
	 */
	float getBrightness();
}
