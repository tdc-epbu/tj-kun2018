package jp.co.tdc.epbu.tjkun.strategy;

import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.Travel;

/**
 * 階段シナリオ
 * @author t2015133
 *
 */
public class StairsScenario extends Scenario {

	public StairsScenario(List<Travel> travelList, List<SectionSwitchingCondition> SwitchConditionList) {
		super(travelList, SwitchConditionList);
	}

	@Override
	public void recoveryCorrespond() {
		// TODO
	}
}
