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
public abstract class Scenario {

	private List<Travel> travelList;
	private List<SectionSwitchingCondition> switchConditionList;
	int sectionNo = 0;

	public Scenario(List<Travel> travelList, List<SectionSwitchingCondition> SwitchConditionList) {
		this.travelList = travelList;
		this.switchConditionList = SwitchConditionList;
	}

	public void capture(){

		while(true){
			travelList.get(sectionNo).travel();

			if(switchConditionList.get(sectionNo).notifyEndCondition()){
				sectionNo++;
				if(switchConditionList.size() <= sectionNo) break;
			}

			if(switchConditionList.get(sectionNo).notifyAbnormalCondition()){
				recoveryCorrespond();
			}
		}
	}

	public abstract void recoveryCorrespond();


}
