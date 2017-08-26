/**
 *
 */
package jp.co.tdc.epbu.tjkun.section;

import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;

/**
 * @author Takayuki
 *
 */
public class Section {

	private Action action;
	private Condition endCondition;
	private Condition abnormalCondition;


	//private WheelSpeed wheelSpeed;

	//private TravelType travelType;

	//private SectionRunActual sectionRunActual;

	public Section(Action action, Condition endCondition, Condition abnormalCondition){
		this.action = action;
		this.endCondition =endCondition;
		this.abnormalCondition = abnormalCondition;
	}
//	public Section(WheelSpeed wheelSpeed, TravelType travelType, Condition endCondition, Condition abnormalCondition){
//		this.wheelSpeed = wheelSpeed;
//		this.travelType = travelType;
//		this.endCondition =endCondition;
//		this.abnormalCondition = abnormalCondition;
//		this.sectionRunActual = new SectionRunActual(EV3.getInstance());
//	}
//
//	/**
//	 * 異常値を判定する
//	 */
//	public boolean judgeAbnormal(){
//		return sectionRunActual.notify(abnormalCondition);
//	}
//
//	/**
//	 * 区間の終了を判定する
//	 * @return
//	 */
//	public boolean judgeEndOfSection(){
//		return sectionRunActual.notify(endCondition);
//	}
//
//	public void startMeasure(){
//		sectionRunActual.start();
//	}
//
//
//	public WheelSpeed getWheelspeed() {
//		return wheelSpeed;
//	}
//

	/**
	 * @return endCondition
	 */
	public Condition getEndCondition() {
		return endCondition;
	}

	/**
	 * @return abnormalCondition
	 */
	public Condition getAbnormalCondition() {
		return abnormalCondition;
	}

	public TravelType getTravelType() {
		return action.getTravelType();
	}

	public WheelSpeed getSpeed() {
		return action.getSpeed();
	}

	public int getTailAngle() {
		return action.getTailAngle();
	}
}
