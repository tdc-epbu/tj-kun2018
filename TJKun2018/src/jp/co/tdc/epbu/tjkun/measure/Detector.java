package jp.co.tdc.epbu.tjkun.measure;

/**
 * 各種センサー値が閾値を超えた時の通知を行うインターフェース
 *
 * @author Anzai Takashi
 *
 */

public interface Detector {

	/**
	 * ライン検知チェック。
	 *
	 * @return true なら灰色を検知したことを通知。
	 */
	public boolean LineIsGray();


	/**
	 * 障害物検知チェック。
	 *
	 * @return true なら障害物を検知したことを通知。
	 */
	public boolean ObstaclesIsBeing();


	/**
	 * ライン検知チェック。
	 *
	 * @return true なら灰色を検知したことを通知。
	 */


	public boolean VibrationIsBeing();
	/**
	 * ライン検知チェック。
	 *
	 * @return true なら灰色を検知したことを通知。
	 */


	public boolean LeftMoterIsBeing();
	/**
	 * ライン検知チェック。
	 *
	 * @return true なら灰色を検知したことを通知。
	 */


	public boolean RightMoterIsBeing();


}
