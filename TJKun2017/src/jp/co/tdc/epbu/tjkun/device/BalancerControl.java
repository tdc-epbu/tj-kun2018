package jp.co.tdc.epbu.tjkun.device;


/**
 * 倒立走行のインターフェース
 * @author tdc
 *
 */
public interface BalancerControl {
	/**
	 * 走行制御
	 *
	 * @param forward
	 *            前進・後進
	 * @param turn
	 *            旋回
	 * @param tail
	 *            尻尾の角度
	 */
	public void controlBalance(float forward, float turn, int tail);
}
