/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import java.util.ArrayList;
import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;
import jp.co.tdc.epbu.tjkun.section.Condition;
import jp.co.tdc.epbu.tjkun.section.ConditionType;
import jp.co.tdc.epbu.tjkun.section.Course;
import jp.co.tdc.epbu.tjkun.section.Section;

/**
 * @author Takayuki
 *
 */
public class CourceFactory {

	public static Course create(CourceType courceType){

		List<Section> sectionList;

		switch (courceType) {
		case LEFT:
			sectionList = createLeftCource();
			break;
		case RIGHT:
			sectionList = createRightCource();
			break;
		case GATE:
			sectionList = createGate();
			break;
		case STAIRS:
			sectionList = createStairs();
			break;
		default:
			sectionList = createLeftCource();
		}

		return new Course(sectionList);
	}

	private static List<Section> createLeftCource() {

		List<Section> sectionList  = new ArrayList<>();

		sectionList.addAll(createStart());
		sectionList.addAll(createToLeftGoal());
		sectionList.addAll(createStairs());
		sectionList.addAll(createLeftGarage());

		return sectionList;
	}
	private static List<Section> createRightCource() {

		List<Section> sectionList  = new ArrayList<>();
		sectionList.addAll(createStart());
		sectionList.addAll(createToRightGoal());
		sectionList.addAll(createGate());
		sectionList.addAll(createRightGarage());

		return sectionList;
	}

	private static Section createSection(TravelType actType, int lSpeed, int rSpeed, int tail,
			ConditionType endCon, float endVal, int turn) {

		Condition endCondition = new Condition(endCon, endVal);
		WheelSpeed speed = new WheelSpeed(lSpeed, rSpeed, turn);
		return new Section(speed, actType, endCondition, tail);
	}

	private static Section createSection(TravelType actType, int lSpeed, int rSpeed, int tail,
			ConditionType endCon, float endVal) {

		Condition endCondition = new Condition(endCon, endVal);
		WheelSpeed speed = new WheelSpeed(lSpeed, rSpeed, 0);
		return new Section(speed, actType, endCondition, tail);
	}



	private static List<Section> createToRightGoal() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, turn);
		// ストレート
		sectionList.add(createSection(TravelType.PID, 100, 100, 0, ConditionType.DISTANCE, 2900, 0));
		// 緩いカーブ
		sectionList.add(createSection(TravelType.PID, 90, 90, 0, ConditionType.DISTANCE, 4800, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 80, 80, 0, ConditionType.DISTANCE, 2000, 0));
		// 緩いカーブ
		sectionList.add(createSection(TravelType.PID, 90, 90, 0, ConditionType.DISTANCE, 400, 0));
		// ストレート
		sectionList.add(createSection(TravelType.PID, 120, 120, 0, ConditionType.DISTANCE, 2800, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 30, 30, 0, ConditionType.DISTANCE, 2000, 0));

		return sectionList;
	}


	private static List<Section> createGate() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, turn);
		// 障害物検知
		sectionList.add(createSection(TravelType.PID, 15, 15, 95, ConditionType.OBSTACLES_DETECTION, 0.1f, 0));
		// 尻尾下ろし
		sectionList.add(createSection(TravelType.BALANCE, -30, -30, 95, ConditionType.TIME, 500, 0));
		sectionList.add(createSection(TravelType.DIRECT, 0, 0, 92, ConditionType.TAIL_ANGLE, 0, 0));
		sectionList.add(createSection(TravelType.DIRECT, 0, 0, 88, ConditionType.TAIL_ANGLE, 0, 0));
		sectionList.add(createSection(TravelType.DIRECT, 0, 0, 82, ConditionType.TAIL_ANGLE, 0, 0));
		sectionList.add(createSection(TravelType.DIRECT, 0, 0, 78, ConditionType.TAIL_ANGLE, 0, 0));
		sectionList.add(createSection(TravelType.DIRECT, 0, 0, 75, ConditionType.TAIL_ANGLE, 0, 0));
		sectionList.add(createSection(TravelType.DIRECT, 0, 0, 73, ConditionType.TAIL_ANGLE, 0, 0));
		// 前進
		sectionList.add(createSection(TravelType.DIRECT, 20, 20, 0, ConditionType.DISTANCE, 350, 0));
		// 後退
		sectionList.add(createSection(TravelType.DIRECT, -20, -21, 0, ConditionType.DISTANCE, 480, 0));
		// 前進(車庫まで)
		sectionList.add(createSection(TravelType.DIRECT, 20, 20, 0, ConditionType.DISTANCE, 1300, 0));
		// ストップ
		sectionList.add(createSection(TravelType.DIRECT, 0, 0, 0, ConditionType.DISTANCE, 6000, 0));
		sectionList.add(createSection(TravelType.DIRECT, 0, 0, 0, ConditionType.TIME, 5000, 0));

		return sectionList;
	}

	private static List<Section> createRightGarage() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, turn);
		//TODO

		return sectionList;
	}


	private static List<Section> createToLeftGoal() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, turn);
		// ストレート
		sectionList.add(createSection(TravelType.PID, 120, 120, 0, ConditionType.DISTANCE, 2900, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 80, 80, 0, ConditionType.DISTANCE, 2000, 0));
		// ほぼストレート
		sectionList.add(createSection(TravelType.PID, 100, 100, 0, ConditionType.DISTANCE, 1800, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 60, 60, 0, ConditionType.DISTANCE, 700, 0));
		// ストレート
		sectionList.add(createSection(TravelType.PID, 100, 100, 0, ConditionType.DISTANCE, 1800, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 70, 70, 0, ConditionType.DISTANCE, 2000, 0));
		// ストレート
		sectionList.add(createSection(TravelType.PID, 100, 100, 0, ConditionType.DISTANCE, 2700, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.PID, 30, 30, 0, ConditionType.DISTANCE, 2500, 0));
		// 急なカーブ
		sectionList.add(createSection(TravelType.JAGGY, 20, 20, 0, ConditionType.DISTANCE, 2500, 0));

		return sectionList;
	}

	private static List<Section> createStairs() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, turn);
		// 衝突検知
		sectionList.add(createSection(TravelType.PID, 10, 10, 0, ConditionType.CONFLICT_DETECTION, 0.1f, 0));
		// 後退
		sectionList.add(createSection(TravelType.PID, -10, -10, 0, ConditionType.DISTANCE, 100, 0));
		// 1段目昇段
		sectionList.add(createSection(TravelType.PID, 80, 80, 0, ConditionType.DISTANCE, 150, 0));
		// 衝突検知
		sectionList.add(createSection(TravelType.PID, 10, 10, 0, ConditionType.CONFLICT_DETECTION, 0.1f, 0));
		// 後退
		sectionList.add(createSection(TravelType.PID, -10, -10, 0, ConditionType.DISTANCE, 50, 0));
		// スピン
		sectionList.add(createSection(TravelType.SPIN, 0, 0, 0, ConditionType.DISTANCE, 50, 10));
		// 2段目昇段
		sectionList.add(createSection(TravelType.PID, 80, 80, 0, ConditionType.DISTANCE, 150, 0));
		// 直角攻略
		sectionList.add(createSection(TravelType.JAGGY, 5, 5, 0, ConditionType.CONFLICT_DETECTION, 0.1f, 0));

		return sectionList;
	}

	private static List<Section> createLeftGarage() {

		List<Section> sectionList = new ArrayList<>();

		//              createSection(actType, lSpeed, rSpeed, tail, endCon, endVal, turn);
		//TODO
		return sectionList;
	}



	private static List<Section> createStart() {
		List<Section> sectionList = new ArrayList<>();

		sectionList.add(createSection(TravelType.PID, 10, 10, 95, ConditionType.TIME, 500));
		sectionList.add(createSection(TravelType.PID, 50, 50, 0, ConditionType.DISTANCE, 200, 0));

		return sectionList;
	}


}
