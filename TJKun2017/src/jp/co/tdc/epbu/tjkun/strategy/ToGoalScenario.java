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

	@Override
	public void recoveryCorrespond() {
		// TODO 適当な例
		sectionNo--;
		// sectionNoが一定値以下の場合、sectionNoを0に設定とか
		// ファクトリーで復帰行動を登録しておき、その動作をさせるとか

	}

}
