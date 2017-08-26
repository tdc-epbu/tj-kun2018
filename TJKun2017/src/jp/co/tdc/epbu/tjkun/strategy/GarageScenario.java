package jp.co.tdc.epbu.tjkun.strategy;

import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.Travel;

/**
 * 車庫シナリオ
 * @author t2015133
 *
 */
public class GarageScenario extends Scenario {

	public GarageScenario(List<Travel> travelList, List<SectionSwitchingCondition> SwitchConditionList) {
		super(travelList, SwitchConditionList);
	}

	@Override
	public void recoveryCorrespond() {
		// TODO

	}

}
