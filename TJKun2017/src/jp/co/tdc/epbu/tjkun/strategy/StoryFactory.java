/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import java.util.ArrayList;
import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.Travel;
import jp.co.tdc.epbu.tjkun.drive.TravelJaggyImpl;
import jp.co.tdc.epbu.tjkun.drive.TravelPidImpl;
import jp.co.tdc.epbu.tjkun.drive.TravelSpinImpl;
import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;
import jp.co.tdc.epbu.tjkun.measure.BlackLineDetection;
import jp.co.tdc.epbu.tjkun.measure.Detection;
import jp.co.tdc.epbu.tjkun.section.Action;
import jp.co.tdc.epbu.tjkun.section.Area;
import jp.co.tdc.epbu.tjkun.section.Condition;
import jp.co.tdc.epbu.tjkun.section.CourceType;
import jp.co.tdc.epbu.tjkun.section.Course;
import jp.co.tdc.epbu.tjkun.section.Section;

/**
 * @author t2011002
 *
 */
public class StoryFactory {

	/*
	 * ストーリー製造
	 */
	public static Story create(CourceType courceType) {

		Course course = CourceFactory.create(courceType);

		Story story = new Story();
		story.setScenarioList(createScenarioList(course.getAreaList()));

		return story;
	}

	/*
	 * シナリオリスト製造
	 */
	private static List<Scenario> createScenarioList(List<Area> areaList) {

		List<Scenario> scenarioList = new ArrayList<>();

		for (Area area : areaList) {
			scenarioList.add(createScenario(area));
		}

		return scenarioList;
	}

	/*
	 * シナリオ製造
	 */
	private static Scenario createScenario(Area area) {

		List<Travel> travelList = createTravelList(area.getSectionList());
		List<SectionSwitchingCondition> switchConditionList = createswitchConditionList(area.getSectionList());

		Scenario scenario = null;
		switch (area.getAreaType()) {
		case PREPARATION:
			// TODO scenario = new
			break;
		case START:
			scenario = new ToGoalScenario(travelList, switchConditionList);
			break;
		case TO_GOAL:
			scenario = new ToGoalScenario(travelList, switchConditionList);
			break;
		case STAIRS:
			scenario = new StairsScenario(travelList, switchConditionList);
			break;
		case GATE:
			scenario = new GateScenario(travelList, switchConditionList);
			break;
		case GARAGE:
			scenario = new GarageScenario(travelList, switchConditionList);
			break;
		default:
		}

		return scenario;
	}

	/*
	 * 走行リスト製造
	 */
	private static List<Travel> createTravelList(List<Section> sectionList) {

		List<Travel> travelList = new ArrayList<>();
		Action action = new Action();
		WheelSpeed speed = action.getSpeed();
		int tail = action.getTailAngle();

		for (Section section : sectionList) {
			Travel travel = null;
			switch (section.getTravelType()) {
			// ジグザグ走行
			// TODO パラメータにtail追加
			case JAGGY:
				travel = new TravelJaggyImpl(speed);
				break;
			// PID走行
			// TODO パラメータにtail追加
			case PID:
				travel = new TravelPidImpl(speed);
				break;
			// スピン
			// TODO パラメータにtail追加
			case SPIN:
				travel = new TravelSpinImpl(speed);
				break;
			// ライントレースOFF
			case BALANCE:
//				travel = new TravelTailControlRun(speed, tail);
				break;
			// ダイレクト
			case DIRECT:
//				travel = new TravelTailDownImpl(speed);
				break;
			default:
				break;
			}

			travelList.add(travel);
		}
		return travelList;
	}

	/*
	 * 区間切り替え条件リスト製造
	 */
	private static List<SectionSwitchingCondition> createswitchConditionList(List<Section> sectionList) {

		List<SectionSwitchingCondition> switchConditionList = new ArrayList<>();

		for (Section section : sectionList) {
			switchConditionList.add(createSwitchCondition(section));
		}

		return switchConditionList;
	}

	/*
	 * 区間切り替え条件製造
	 */
	private static SectionSwitchingCondition createSwitchCondition(Section section) {

		List<Detection> endDetectorList = createDetector(section.getEndCondition());
		List<Detection> abnormalDetectorList = createDetector(section.getAbnormalCondition());

		SectionSwitchingCondition switchCondition = new SectionSwitchingCondition(endDetectorList,
				abnormalDetectorList);
		return switchCondition;
	}

	/*
	 * 検知器リスト製造
	 */
	private static List<Detection> createDetector(Condition condition) {

		List<Detection> detectorList = new ArrayList<>();
		// TODO コース情報作成の都合上、一旦Sectionの判定条件はリストでなく単一所持にしている
		int blackline = 0;
		// for (Condition condition : conditionList) {
		Detection detection = null;
		switch (condition.getConditionType()) {
		// ライン検知
		case BLACK_DETECTION:
			detection = new BlackLineDetection(blackline);
			break;
		// TODO 振動検知
//		case COLLISION_DETECTION:
//			detection = new CollisionSensor(condition.getConditionValue());
//			break;
		// TODO 障害物検知
//		case DISTANCE:
//			break;
		// TODO 左車輪回転数検知
//		case GRAY_DETECTION:
//			detection = new
//			break;
		// TODO 右車輪回転数検知
//			case GRAY_DETECTION:
//				detection = new
//				break;
		default:
			break;
		}
		detectorList.add(detection);
		// }

		return detectorList;
	}

}