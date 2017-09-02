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
		case TEST:
			areaList = createTest();
			break;
		default:
			areaList = createLeftCource();
		}

		return new Course(areaList);
	}

	private static List<Area> createTest() {

		List<Area> areaList  = new ArrayList<>();

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, excepCon, excepVal);
		sectionList.add(createSection(TravelType.PID, 10, 10, 95, ConditionType.TIME, 500, null, 0));
		sectionList.add(createSection(TravelType.PID, 20, 20, 0, ConditionType.LEFT_DISTANCE, 15200, null, 0));

		areaList.add(new Area(sectionList, AreaType.TO_GOAL));
		return areaList;
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

	private static Section createSection(TravelType actType, int lSpeed, int rSpeed, int tail,
			ConditionType endCon, float endVal, ConditionType excepCon, float excepVal, int turn) {

		Action action = new Action();
		action.setTravelType(actType);
		action.setSpeed(new WheelSpeed(lSpeed, rSpeed, turn));
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
		sectionList.add(createSection(TravelType.PID, 50, 50, 88, ConditionType.LEFT_DISTANCE, 200, null, 0));

		List<Area> areaList  = new ArrayList<>();
		areaList.add(new Area(sectionList, AreaType.TO_GOAL));
		return areaList;
	}

	private static List<Area> createToLeftGoal() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, excepCon, excepVal);
		// ストレート
		sectionList.add(createSection(TravelType.PID, 120, 120, 0, ConditionType.LEFT_DISTANCE, 2900, null, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 80, 80, 0, ConditionType.LEFT_DISTANCE, 2000, null, 0));
		// ほぼストレート
		sectionList.add(createSection(TravelType.PID, 100, 100, 0, ConditionType.LEFT_DISTANCE, 1800, null, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 60, 60, 0, ConditionType.LEFT_DISTANCE, 700, null, 0));
		// ストレート
		sectionList.add(createSection(TravelType.PID, 100, 100, 0, ConditionType.LEFT_DISTANCE, 1800, null, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 70, 70, 0, ConditionType.LEFT_DISTANCE, 2000, null, 0));
		// ストレート
		sectionList.add(createSection(TravelType.PID, 100, 100, 0, ConditionType.LEFT_DISTANCE, 2700, null, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 30, 30, 0, ConditionType.LEFT_DISTANCE, 2500, null, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.JAGGY, 20, 20, 0, ConditionType.LEFT_DISTANCE, 2500, null, 0));

		List<Area> areaList  = new ArrayList<>();
		areaList.add(new Area(sectionList, AreaType.TO_GOAL));
		return areaList;
	}

	private static List<Area> createStairs() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, excepCon, excepVal);
		// 衝突検知
		sectionList.add(createSection(TravelType.PID, 10, 10, 0, ConditionType.COLLISION_DETECTION, 0.1f, null, 0));
		// 後退
		sectionList.add(createSection(TravelType.PID, -10, -10, 0, ConditionType.LEFT_DISTANCE, 100, null, 0));
		// 1段目昇段
		sectionList.add(createSection(TravelType.PID, 80, 80, 0, ConditionType.LEFT_DISTANCE, 150, null, 0));
		// 衝突検知
		sectionList.add(createSection(TravelType.PID, 10, 10, 0, ConditionType.COLLISION_DETECTION, 0.1f, null, 0));
		// 後退
		sectionList.add(createSection(TravelType.PID, -10, -10, 0, ConditionType.LEFT_DISTANCE, 50, null, 0));
		// スピン
		sectionList.add(createSection(TravelType.SPIN, 40, 0, 0, ConditionType.LEFT_DISTANCE, 50, null, 0));
		// 2段目昇段
		sectionList.add(createSection(TravelType.PID, 80, 80, 0, ConditionType.LEFT_DISTANCE, 150, null, 0));
		// 直角攻略
		sectionList.add(createSection(TravelType.JAGGY, 10, 10, 0, ConditionType.COLLISION_DETECTION, 0.1f, null, 0));

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
		sectionList.add(createSection(TravelType.PID, 120, 120, 0, ConditionType.LEFT_DISTANCE, 2900, null, 0));
		// 緩いカーブ
		sectionList.add(createSection(TravelType.PID, 90, 90, 0, ConditionType.LEFT_DISTANCE, 4800, null, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 80, 80, 0, ConditionType.LEFT_DISTANCE, 2000, null, 0));
		// 緩いカーブ
		sectionList.add(createSection(TravelType.PID, 90, 90, 0, ConditionType.LEFT_DISTANCE, 400, null, 0));
		// ストレート
		sectionList.add(createSection(TravelType.PID, 120, 120, 0, ConditionType.LEFT_DISTANCE, 2800, null, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 30, 30, 0, ConditionType.LEFT_DISTANCE, 2000, null, 0));

		List<Area> areaList  = new ArrayList<>();
		areaList.add(new Area(sectionList, AreaType.TO_GOAL));
		return areaList;
	}


	private static List<Area> createGate() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, excepCon, excepVal);
		// 障害物検知
		sectionList.add(createSection(TravelType.PID, 15, 15, 0, ConditionType.OBSTACLES_DETECTION, 0.1f, null, 0));
		// 尻尾下ろし
		sectionList.add(createSection(TravelType.BALANCE, -30, -30, 0, ConditionType.TIME, 500, null, 0));
		sectionList.add(createSection(TravelType.DIRECT, 0, 0, 88, ConditionType.TAIL_ANGLE, 0, null, 0));
		sectionList.add(createSection(TravelType.DIRECT, 0, 0, 82, ConditionType.TAIL_ANGLE, 0, null, 0));
		sectionList.add(createSection(TravelType.DIRECT, 0, 0, 78, ConditionType.TAIL_ANGLE, 0, null, 0));
		sectionList.add(createSection(TravelType.DIRECT, 0, 0, 75, ConditionType.TAIL_ANGLE, 0, null, 0));
		sectionList.add(createSection(TravelType.DIRECT, 0, 0, 73, ConditionType.TAIL_ANGLE, 0, null, 0));
		// 前進
		sectionList.add(createSection(TravelType.DIRECT, 20, 20, 0, ConditionType.LEFT_DISTANCE, 350, null, 0));
		// 後退
		sectionList.add(createSection(TravelType.DIRECT, -20, -21, 0, ConditionType.LEFT_DISTANCE, 480, null, 0));
		// 前進(車庫まで)
		sectionList.add(createSection(TravelType.DIRECT, 20, 20, 0, ConditionType.LEFT_DISTANCE, 1300, null, 0));
		// ストップ
		sectionList.add(createSection(TravelType.DIRECT, 0, 0, 0, ConditionType.LEFT_DISTANCE, 6000, null, 0));
		sectionList.add(createSection(TravelType.DIRECT, 0, 0, 0, ConditionType.TIME, 5000, null, 0));

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
