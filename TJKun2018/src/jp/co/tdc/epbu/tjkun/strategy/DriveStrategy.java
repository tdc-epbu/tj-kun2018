/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import jp.co.tdc.epbu.tjkun.section.Course;

/**
 * @author Takayuki
 *
 */
public interface DriveStrategy {

	/** 指示する
	 * @throws InterruptedException */
	public void operate(Course cource) throws InterruptedException;

}
