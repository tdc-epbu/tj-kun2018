/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.Travel;
import jp.co.tdc.epbu.tjkun.measure.SectionRunActual;

/**
 * @author t2011002
 *
 */
public abstract class Scenario {

	protected List<Travel> travelList;
	protected List<SectionSwitchingCondition> switchConditionList;
	protected int sectionNo = 0;

	public Scenario(List<Travel> travelList, List<SectionSwitchingCondition> SwitchConditionList) {
		this.travelList = travelList;
		this.switchConditionList = SwitchConditionList;
	}

	public void capture(){

		// 区間計測の開始
		SectionRunActual.getInstance().start();

		while(true){
			travelList.get(sectionNo).travel();

			if(switchConditionList.get(sectionNo).notifyEndCondition()){
				sectionNo++;
				if(switchConditionList.size() <= sectionNo) break;
				// 区間が変更されたため、再度区間計測の開始
				SectionRunActual.getInstance().start();
			}

			if(switchConditionList.get(sectionNo).notifyAbnormalCondition()){
				recoveryCorrespond();
			}
		}
	}

	public abstract void recoveryCorrespond();


}
