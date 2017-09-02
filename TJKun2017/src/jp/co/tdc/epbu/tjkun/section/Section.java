/**
 *
 */
package jp.co.tdc.epbu.tjkun.section;

import jp.co.tdc.epbu.tjkun.device.EV3;
import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;
import jp.co.tdc.epbu.tjkun.measure.SectionRunActual;
import jp.co.tdc.epbu.tjkun.strategy.TravelType;

/**
 * @author Takayuki
 *
 */
public class Section {


	private WheelSpeed wheelSpeed;

	private TravelType travelType;

	private Condition endCondition;

	private SectionRunActual sectionRunActual;

	private int tail;

	public Section(WheelSpeed wheelSpeed, TravelType travelType, Condition endCondition, int tail){
		this.wheelSpeed = wheelSpeed;
		this.travelType = travelType;
		this.endCondition =endCondition;
		this.tail = tail;
		this.sectionRunActual = new SectionRunActual(EV3.getInstance());
	}


	/**
	 * 区間の終了を判定する
	 * @return
	 */
	public boolean judgeEndOfSection(){
		return sectionRunActual.notify(endCondition);
	}

	public void startMeasure(){
		sectionRunActual.start();
	}


	public WheelSpeed getWheelspeed() {
		return wheelSpeed;
	}

	public TravelType getTravelType() {
		return travelType;
	}

	public int getTail() {
		return tail;
	}
}
