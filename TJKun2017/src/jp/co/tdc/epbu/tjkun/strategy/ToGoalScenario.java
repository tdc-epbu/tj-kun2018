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
public class ToGoalScenario extends Scenario {

	public ToGoalScenario(List<Travel> travelList, List<SectionSwitchingCondition> switchConditionList) {
		super(travelList, switchConditionList);
	}

}
