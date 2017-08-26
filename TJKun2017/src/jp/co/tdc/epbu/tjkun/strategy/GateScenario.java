package jp.co.tdc.epbu.tjkun.strategy;

import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.Travel;

/**
 * ルックアップゲートシナリオ
 * @author t2015133
 *
 */
public class GateScenario extends Scenario {

	public GateScenario(List<Travel> travelList, List<SectionSwitchingCondition> SwitchConditionList) {
		super(travelList, SwitchConditionList);
	}

	@Override
	public void recoveryCorrespond() {
		// TODO
	}

}
