package jp.co.tdc.epbu.tjkun.strategy;

import java.util.ArrayList;
import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;
import jp.co.tdc.epbu.tjkun.section.Condition;
import jp.co.tdc.epbu.tjkun.section.ConditionType;
import jp.co.tdc.epbu.tjkun.section.Section;

public class RightCource {

	public static List<Section> createRightCource() {

		List<Section> sectionList = new ArrayList<>();

		//ストレート
		WheelSpeed speed2 = new WheelSpeed(100, 100);
		Condition condition2 = new Condition(ConditionType.DISTANCE, 2900);
		sectionList.add(new Section(speed2, TravelType.PID, condition2, null));
		//緩いカーブ
		WheelSpeed speed3 = new WheelSpeed(80, 80);
		Condition condition3 = new Condition(ConditionType.DISTANCE, 7200);
		sectionList.add(new Section(speed3, TravelType.PID, condition3, null));
		//急なカーブ
		WheelSpeed speed4 = new WheelSpeed(70, 70);
		Condition condition4 = new Condition(ConditionType.DISTANCE, 2000);
		sectionList.add(new Section(speed4, TravelType.PID, condition4, null));
		//ストレート
		WheelSpeed speed6 = new WheelSpeed(100, 100);
		Condition condition6 = new Condition(ConditionType.DISTANCE, 3900);
		sectionList.add(new Section(speed6, TravelType.PID, condition6, null));
		//急なカーブ
		WheelSpeed speed7 = new WheelSpeed(40, 40);
		Condition condition7 = new Condition(ConditionType.DISTANCE, 2000);
		sectionList.add(new Section(speed7, TravelType.PID, condition7, null));

		return sectionList;
	}
}
