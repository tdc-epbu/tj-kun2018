package jp.co.tdc.epbu.tjkun.strategy;

import java.util.ArrayList;
import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;
import jp.co.tdc.epbu.tjkun.section.Condition;
import jp.co.tdc.epbu.tjkun.section.ConditionType;
import jp.co.tdc.epbu.tjkun.section.Section;

public class Start {

	public static List<Section> createStart() {
		List<Section> sectionList = new ArrayList<>();

		//スタート
		WheelSpeed speed0 = new WheelSpeed(10, 10);
		Condition condition0 = new Condition(ConditionType.TIME, 1000);
		sectionList.add(new Section(speed0, TravelType.PID, condition0, null));
		//スタート
		WheelSpeed speed1 = new WheelSpeed(50, 50);
		Condition condition1 = new Condition(ConditionType.DISTANCE, 100);
		sectionList.add(new Section(speed1, TravelType.PID, condition1, null));

		return sectionList;
	}
}
