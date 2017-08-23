package jp.co.tdc.epbu.tjkun.device;


/**
 * 尻尾の角度の設定・取得を行う。
 * @author tdc
 *
 */
public interface Tail {

	/**
	 * 尻尾の角度を設定する。
	 * @param angle 設定する尻尾の角度
	 */
	void setAngle(int angle);


	/**
	 * 尻尾の角度を取得する。
	 * @return
	 */
	int getAngle();
}
