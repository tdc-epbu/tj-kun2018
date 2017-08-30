/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import java.util.ArrayList;
import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.Travel;
import jp.co.tdc.epbu.tjkun.drive.TravelBalanceImpl;
import jp.co.tdc.epbu.tjkun.drive.TravelDirectImpl;
import jp.co.tdc.epbu.tjkun.drive.TravelJaggyImpl;
import jp.co.tdc.epbu.tjkun.drive.TravelPidImpl;
import jp.co.tdc.epbu.tjkun.drive.TravelSpinImpl;
import jp.co.tdc.epbu.tjkun.measure.BlackLineDetection;
import jp.co.tdc.epbu.tjkun.measure.Detection;
import jp.co.tdc.epbu.tjkun.measure.ElapsedTime;
import jp.co.tdc.epbu.tjkun.measure.GrayLineDetection;
import jp.co.tdc.epbu.tjkun.measure.LeftMoterDetection;
import jp.co.tdc.epbu.tjkun.measure.ObstaclesDetection;
import jp.co.tdc.epbu.tjkun.measure.TailDetection;
import jp.co.tdc.epbu.tjkun.measure.VibrationDetection;
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

		for (Section section : sectionList) {
			Travel travel = null;
			switch (section.getTravelType()) {
			// ジグザグ走行
			case JAGGY:
				travel = new TravelJaggyImpl(section.getSpeed(), section.getTailAngle());
				break;
			// PID走行
			case PID:
				travel = new TravelPidImpl(section.getSpeed(), section.getTailAngle());
				break;
			// スピン
			case SPIN:
				travel = new TravelSpinImpl(section.getSpeed(), section.getTailAngle());
				break;
			// ライントレースOFF
			case BALANCE:
				travel = new TravelBalanceImpl(section.getSpeed(), section.getTailAngle());
				break;
			// ダイレクト
			case DIRECT:
				travel = new TravelDirectImpl(section.getSpeed(), section.getTailAngle());
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
		// List<Detection> abnormalDetectorList =
		// createDetector(section.getAbnormalCondition());

		SectionSwitchingCondition switchCondition = new SectionSwitchingCondition(endDetectorList, null);
		return switchCondition;
	}

	/*
	 * 検知器リスト製造
	 */
	private static List<Detection> createDetector(Condition condition) {

		List<Detection> detectorList = new ArrayList<>();
		// TODO コース情報作成の都合上、一旦Sectionの判定条件はリストでなく単一所持にしている
		// for (Condition condition : conditionList) {
		Detection detection = null;
		switch (condition.getConditionType()) {
		// ライン検知
		case BLACK_DETECTION:
			detection = new BlackLineDetection(condition.getConditionValue());
			break;
		case TIME:
			detection = new ElapsedTime((int) condition.getConditionValue());
			break;
		case DISTANCE:
			detection = new LeftMoterDetection((int) condition.getConditionValue());
			break;
		case COLLISION_DETECTION:
			detection = new VibrationDetection((int) condition.getConditionValue());
			break;
		case OBSTACLES_DETECTION:
			detection = new ObstaclesDetection((int) condition.getConditionValue());
			break;
		case GRAY_DETECTION:
			detection = new GrayLineDetection((int) condition.getConditionValue());
			break;
		case TAIL_ANGLE:
			detection = new TailDetection((int) condition.getConditionValue());
		default:
			break;
		}
		detectorList.add(detection);
		// }

		return detectorList;
	}

}