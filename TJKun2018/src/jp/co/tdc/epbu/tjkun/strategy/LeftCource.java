package jp.co.tdc.epbu.tjkun.strategy;

import java.util.ArrayList;
import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;
import jp.co.tdc.epbu.tjkun.section.Condition;
import jp.co.tdc.epbu.tjkun.section.ConditionType;
import jp.co.tdc.epbu.tjkun.section.Section;

public class LeftCource {
	public static List<Section> createLeftCource() {

		List<Section> sectionList = new ArrayList<>();

		//ストレート
		WheelSpeed speed2 = new WheelSpeed(90, 90);
		Condition condition2 = new Condition(ConditionType.DISTANCE, 3200);
		sectionList.add(new Section(speed2, TravelType.PID, condition2, null));
		//緩いカーブ
		WheelSpeed speed3 = new WheelSpeed(70, 70);
		Condition condition3 = new Condition(ConditionType.DISTANCE, 800);
		sectionList.add(new Section(speed3, TravelType.PID, condition3, null));
		//ストレート
		WheelSpeed speed4 = new WheelSpeed(90, 90);
		Condition condition4 = new Condition(ConditionType.DISTANCE, 1800);
		sectionList.add(new Section(speed4, TravelType.PID, condition4, null));
		//緩いカーブ
		WheelSpeed speed5 = new WheelSpeed(75, 75);
		Condition condition5 = new Condition(ConditionType.DISTANCE, 600);
		sectionList.add(new Section(speed5, TravelType.PID, condition5, null));
		//ストレート
		WheelSpeed speed6 = new WheelSpeed(90, 90);
		Condition condition6 = new Condition(ConditionType.DISTANCE, 1900);
		sectionList.add(new Section(speed6, TravelType.PID, condition6, null));
		//緩いカーブ
		WheelSpeed speed7 = new WheelSpeed(75, 75);
		Condition condition7 = new Condition(ConditionType.DISTANCE, 600);
		sectionList.add(new Section(speed7, TravelType.PID, condition7, null));
//		//ストップ
//		WheelSpeed speed8 = new WheelSpeed(0, 0);
//		Condition condition8 = new Condition(ConditionType.DISTANCE, 6000);
//		sectionList.add(new Section(speed8, TravelType.PID, condition8, null));
//		//ストップ


		sectionList.addAll(LookUpGate.createGateCource());

		WheelSpeed speed9 = new WheelSpeed(0, 0);
		Condition condition9 = new Condition(ConditionType.TIME, 5000);
		sectionList.add(new Section(speed9, TravelType.END, condition9, null));

		return sectionList;
	}
}
