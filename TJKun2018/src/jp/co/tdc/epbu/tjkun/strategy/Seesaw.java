package jp.co.tdc.epbu.tjkun.strategy;

import java.util.ArrayList;
import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;
import jp.co.tdc.epbu.tjkun.section.Condition;
import jp.co.tdc.epbu.tjkun.section.ConditionType;
import jp.co.tdc.epbu.tjkun.section.Section;

public class Seesaw {

	public static List<Section> createSeesaw() {
		List<Section> sectionList = new ArrayList<>();

		//シーソー攻略（未実装）
		//前進
		WheelSpeed speed3 = new WheelSpeed(0, 0);
		Condition condition3 = new Condition(ConditionType.DISTANCE, 420);
		sectionList.add(new Section(speed3, TravelType.TAIL, condition3, null));

		return sectionList;
	}
}
