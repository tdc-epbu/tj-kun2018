/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

/**
 * @author Takayuki
 *
 */
public interface DriveStrategy {

	/** 指示する
	 * @throws InterruptedException */
	public void operate(Story story) throws InterruptedException;

}
