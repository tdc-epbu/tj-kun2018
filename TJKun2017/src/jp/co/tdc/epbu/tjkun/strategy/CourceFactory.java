/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import java.util.ArrayList;
import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;
import jp.co.tdc.epbu.tjkun.section.Action;
import jp.co.tdc.epbu.tjkun.section.Area;
import jp.co.tdc.epbu.tjkun.section.AreaType;
import jp.co.tdc.epbu.tjkun.section.Condition;
import jp.co.tdc.epbu.tjkun.section.ConditionType;
import jp.co.tdc.epbu.tjkun.section.CourceType;
import jp.co.tdc.epbu.tjkun.section.Course;
import jp.co.tdc.epbu.tjkun.section.Section;
import jp.co.tdc.epbu.tjkun.section.TravelType;

/**
 * @author Takayuki
 *
 */
public class CourceFactory {

	public static Course create(CourceType courceType) {

		List<Area> areaList;

		switch (courceType) {
		case LEFT:
			areaList = createLeftCource();
			break;
		case RIGHT:
			areaList = createRightCource();
			break;
		case GATE:
			areaList = createGate();
			break;
		case STAIRS:
			areaList = createStairs();
			break;
		default:
			areaList = createLeftCource();
		}

		return new Course(areaList);
	}

	private static Section createSection(TravelType actType, int lSpeed, int rSpeed, int tail,
			ConditionType endCon, float endVal, ConditionType excepCon, float excepVal) {

		Action action = new Action();
		action.setTravelType(actType);
		action.setSpeed(new WheelSpeed(lSpeed, rSpeed));
		action.setTailAngle(tail);

		Condition endCondition = new Condition(endCon, endVal);

		Condition abnormalCondition = null;
		if (null != excepCon) {
			abnormalCondition = new Condition(excepCon, excepVal);
		}

		return new Section(action, endCondition, abnormalCondition);
	}

	private static List<Area> createStart() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, excepCon, excepVal);
		sectionList.add(createSection(TravelType.PID, 10, 10, 95, ConditionType.TIME, 1000, null, 0));
		sectionList.add(createSection(TravelType.PID, 50, 50, 85, ConditionType.DISTANCE, 200, null, 0));

		List<Area> areaList  = new ArrayList<>();
		areaList.add(new Area(sectionList, AreaType.TO_GOAL));
		return areaList;
	}

	private static List<Area> createToLeftGoal() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, excepCon, excepVal);
		// ストレート
		sectionList.add(createSection(TravelType.PID, 100, 100, 0, ConditionType.DISTANCE, 2900, null, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 70, 70, 0, ConditionType.DISTANCE, 2000, null, 0));
		// ほぼストレート
		sectionList.add(createSection(TravelType.PID, 90, 90, 0, ConditionType.DISTANCE, 1800, null, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 50, 50, 0, ConditionType.DISTANCE, 700, null, 0));
		// ストレート
		sectionList.add(createSection(TravelType.PID, 90, 90, 0, ConditionType.DISTANCE, 1800, null, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 60, 60, 0, ConditionType.DISTANCE, 2000, null, 0));
		// ストレート
		sectionList.add(createSection(TravelType.PID, 90, 90, 0, ConditionType.DISTANCE, 2700, null, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 30, 30, 0, ConditionType.DISTANCE, 2500, null, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.JAGGY, 20, 20, 0, ConditionType.DISTANCE, 2500, null, 0));

		List<Area> areaList  = new ArrayList<>();
		areaList.add(new Area(sectionList, AreaType.TO_GOAL));
		return areaList;
	}

	private static List<Area> createStairs() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, excepCon, excepVal);
		//TODO

		List<Area> areaList  = new ArrayList<>();
		areaList.add(new Area(sectionList, AreaType.STAIRS));
		return areaList;
	}

	private static List<Area> createLeftGarage() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, excepCon, excepVal);
		//TODO

		List<Area> areaList  = new ArrayList<>();
		areaList.add(new Area(sectionList, AreaType.GARAGE));
		return areaList;
	}

	private static List<Area> createLeftCource() {

		List<Area> areaList  = new ArrayList<>();

		areaList.addAll(createStart());
		areaList.addAll(createToLeftGoal());
		areaList.addAll(createStairs());
		areaList.addAll(createLeftGarage());

		return areaList;
	}


	private static List<Area> createToRightGoal() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, excepCon, excepVal);
		// ストレート
		sectionList.add(createSection(TravelType.PID, 100, 100, 0, ConditionType.DISTANCE, 2900, null, 0));
		// 緩いカーブ
		sectionList.add(createSection(TravelType.PID, 80, 80, 0, ConditionType.DISTANCE, 4800, null, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 70, 70, 0, ConditionType.DISTANCE, 2000, null, 0));
		// 緩いカーブ
		sectionList.add(createSection(TravelType.PID, 80, 80, 0, ConditionType.DISTANCE, 400, null, 0));
		// ストレート
		sectionList.add(createSection(TravelType.PID, 100, 100, 0, ConditionType.DISTANCE, 2800, null, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 40, 40, 0, ConditionType.DISTANCE, 2000, null, 0));

		List<Area> areaList  = new ArrayList<>();
		areaList.add(new Area(sectionList, AreaType.TO_GOAL));
		return areaList;
	}


	private static List<Area> createGate() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, excepCon, excepVal);
		// 障害物検知
		sectionList.add(createSection(TravelType.PID, 20, 20, 0, ConditionType.OBSTACLES_DETECTION, 0.1f, null, 0));
		// 尻尾下ろし
		sectionList.add(createSection(TravelType.TAILCONTROL, -30, -30, 0, ConditionType.TIME, 500, null, 0));
		sectionList.add(createSection(TravelType.TAILDOWN, 0, 0, 85, ConditionType.TAIL_ANGLE, 0, null, 0));
		sectionList.add(createSection(TravelType.TAILDOWN, 0, 0, 82, ConditionType.TAIL_ANGLE, 0, null, 0));
		sectionList.add(createSection(TravelType.TAILDOWN, 0, 0, 78, ConditionType.TAIL_ANGLE, 0, null, 0));
		sectionList.add(createSection(TravelType.TAILDOWN, 0, 0, 75, ConditionType.TAIL_ANGLE, 0, null, 0));
		sectionList.add(createSection(TravelType.TAILDOWN, 0, 0, 73, ConditionType.TAIL_ANGLE, 0, null, 0));
		// 前進
		sectionList.add(createSection(TravelType.TAIL, 20, 20, 0, ConditionType.DISTANCE, 350, null, 0));
		// 後退
		sectionList.add(createSection(TravelType.TAIL, -20, -21, 0, ConditionType.DISTANCE, 480, null, 0));
		// 前進(車庫まで)
		sectionList.add(createSection(TravelType.TAIL, 20, 20, 0, ConditionType.DISTANCE, 1300, null, 0));
		// ストップ
		sectionList.add(createSection(TravelType.TAIL, 0, 0, 0, ConditionType.DISTANCE, 6000, null, 0));
		sectionList.add(createSection(TravelType.END, 0, 0, 0, ConditionType.TIME, 5000, null, 0));

		List<Area> areaList  = new ArrayList<>();
		areaList.add(new Area(sectionList, AreaType.GATE));
		return areaList;
	}

	private static List<Area> createRightGarage() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, excepCon, excepVal);
		//TODO

		List<Area> areaList  = new ArrayList<>();
		areaList.add(new Area(sectionList, AreaType.GARAGE));
		return areaList;
	}

	private static List<Area> createRightCource() {

		List<Area> areaList  = new ArrayList<>();
		areaList.addAll(createStart());
		areaList.addAll(createToRightGoal());
		areaList.addAll(createGate());
		areaList.addAll(createRightGarage());

		return areaList;
	}

}
