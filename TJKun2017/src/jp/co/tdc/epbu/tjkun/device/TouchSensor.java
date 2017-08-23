package jp.co.tdc.epbu.tjkun.device;

public interface TouchSensor {


	/**
	 * タッチセンサー押下のチェック。
	 *
	 * @return true ならタッチセンサーが押された。
	 */
	public boolean touchSensorIsPressed();
}
