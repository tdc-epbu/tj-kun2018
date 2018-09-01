package jp.co.tdc.epbu.tjkun.strategy;

import java.util.ArrayList;
import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;
import jp.co.tdc.epbu.tjkun.section.Condition;
import jp.co.tdc.epbu.tjkun.section.ConditionType;
import jp.co.tdc.epbu.tjkun.section.Section;

public class LookUpGate {
	public static List<Section> createGateCource() {

		List<Section> sectionList = new ArrayList<>();

		//ゲート検知まで
//		WheelSpeed speed0 = new WheelSpeed(5, 5);
//		Condition condition0 = new Condition(ConditionType.TIME, 5000);
//		sectionList.add(new Section(speed0, TravelType.PID, condition0, null));

		WheelSpeed speed1 = new WheelSpeed(20, 20);
		Condition condition1 = new Condition(ConditionType.OBSTACLES_DETECTION, 0.1f);
		sectionList.add(new Section(speed1, TravelType.TAILCONTROL, condition1, null));
		//尻尾下ろし
		WheelSpeed speed2 = new WheelSpeed(-30, -30);
		Condition condition2 = new Condition(ConditionType.TIME, 500);
		sectionList.add(new Section(speed2, TravelType.TAILCONTROL, condition2, null));
		//尻尾下ろし
		WheelSpeed speed2_2 = new WheelSpeed(0, 0);
		Condition condition2_2 = new Condition(ConditionType.TAIL_ANGLE, 86);
		sectionList.add(new Section(speed2_2, TravelType.TAILDOWN, condition2_2, null));

		condition2_2 = new Condition(ConditionType.TAIL_ANGLE, 84);
		sectionList.add(new Section(speed2_2, TravelType.TAILDOWN, condition2_2, null));
		condition2_2 = new Condition(ConditionType.TAIL_ANGLE, 82);
		sectionList.add(new Section(speed2_2, TravelType.TAILDOWN, condition2_2, null));
		condition2_2 = new Condition(ConditionType.TAIL_ANGLE, 78);
		sectionList.add(new Section(speed2_2, TravelType.TAILDOWN, condition2_2, null));
		condition2_2 = new Condition(ConditionType.TAIL_ANGLE, 75);
		sectionList.add(new Section(speed2_2, TravelType.TAILDOWN, condition2_2, null));
		condition2_2 = new Condition(ConditionType.TAIL_ANGLE, 73);
		sectionList.add(new Section(speed2_2, TravelType.TAILDOWN, condition2_2, null));

		//前進
		WheelSpeed speed3 = new WheelSpeed(20, 20);
		Condition condition3 = new Condition(ConditionType.DISTANCE, 420);
		sectionList.add(new Section(speed3, TravelType.TAIL, condition3, null));
		//後退
		WheelSpeed speed4 = new WheelSpeed(-20, -21);
		Condition condition4 = new Condition(ConditionType.DISTANCE, 480);
		sectionList.add(new Section(speed4, TravelType.TAIL, condition4, null));
//		WheelSpeed speed4 = new WheelSpeed(50, -50);
//		Condition condition4 = new Condition(ConditionType.DISTANCE, 250);
//		sectionList.add(new Section(speed4, TravelType.TAIL, condition4, null));
		//前進
//		WheelSpeed speed5 = new WheelSpeed(50, 50);
//		Condition condition5 = new Condition(ConditionType.DISTANCE, 400);
//		sectionList.add(new Section(speed5, TravelType.TAIL, condition5, null));
		//旋回
//		WheelSpeed speed6 = new WheelSpeed(50, -50);
//		Condition condition6 = new Condition(ConditionType.DISTANCE, 250);
//		sectionList.add(new Section(speed6, TravelType.TAIL, condition6, null));
		//前進(車庫まで)
		WheelSpeed speed7 = new WheelSpeed(20, 20);
		Condition condition7 = new Condition(ConditionType.DISTANCE, 1300);
		sectionList.add(new Section(speed7, TravelType.TAIL, condition7, null));
		//ストップ
		WheelSpeed speed8 = new WheelSpeed(0, 0);
		Condition condition8 = new Condition(ConditionType.DISTANCE, 6000);
		sectionList.add(new Section(speed8, TravelType.TAIL, condition8, null));
		//ストップ
		WheelSpeed speed9 = new WheelSpeed(0, 0);
		Condition condition9 = new Condition(ConditionType.TIME, 5000);
		sectionList.add(new Section(speed9, TravelType.END, condition9, null));

		return sectionList;
	}
}
