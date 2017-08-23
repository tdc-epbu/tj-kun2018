package jp.co.tdc.epbu.tjkun.device;

public interface UltrasonicSensor {
	/**
	 * 超音波センサーにより障害物との距離を取得する。
	 *
	 * @return 障害物との距離(m)。
	 */
	public float getSonarDistance();
}
