/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.Travel;

/**
 * @author t2011002
 *
 */
public class Scenario {

	private List<Travel> travelList;
	private List<SectionSwitchingCondition> switchConditionList;

	public Scenario(List<Travel> travelList, List<SectionSwitchingCondition> SwitchConditionList) {
		this.travelList = travelList;
		this.switchConditionList = SwitchConditionList;
	}

	/**
	 * @return travelList
	 */
	public List<Travel> getTravelList() {
		return travelList;
	}
	/**
	 * @param travelList セットする travelList
	 */
	public void setTravelList(List<Travel> travelList) {
		this.travelList = travelList;
	}
	/**
	 * @return switchConditionList
	 */
	public List<SectionSwitchingCondition> getSwitchConditionList() {
		return switchConditionList;
	}
	/**
	 * @param switchConditionList セットする switchConditionList
	 */
	public void setSwitchConditionList(List<SectionSwitchingCondition> switchConditionList) {
		this.switchConditionList = switchConditionList;
	}

}
