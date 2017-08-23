/**
 *
 */
package jp.co.tdc.epbu.tjkun.section;

import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;

/**
 * @author t2011002
 *
 */
public class Action {

	private TravelType travelType;
	private WheelSpeed speed;
	private int tailAngle;

	/**
	 * @return travelType
	 */
	public TravelType getTravelType() {
		return travelType;
	}
	/**
	 * @param travelType セットする travelType
	 */
	public void setTravelType(TravelType travelType) {
		this.travelType = travelType;
	}
	/**
	 * @return speed
	 */
	public WheelSpeed getSpeed() {
		return speed;
	}
	/**
	 * @param speed セットする speed
	 */
	public void setSpeed(WheelSpeed speed) {
		this.speed = speed;
	}
	/**
	 * @return tailAngle
	 */
	public int getTailAngle() {
		return tailAngle;
	}
	/**
	 * @param tailAngle セットする tailAngle
	 */
	public void setTailAngle(int tailAngle) {
		this.tailAngle = tailAngle;
	}
}
