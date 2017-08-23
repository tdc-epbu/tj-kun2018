/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import java.util.ArrayList;
import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.Travel;
import jp.co.tdc.epbu.tjkun.measure.CollisionSensor;
import jp.co.tdc.epbu.tjkun.measure.Detector;
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
			// TODO scenario = new
			break;
		case STAIRS:
			// TODO scenario = new
			break;
		case GATE:
			// TODO scenario = new
			break;
		case GARAGE:
			// TODO scenario = new
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
			case END:
				// TODO travel = new
				break;
			case JAGGY:
				// TODO travel = new
				break;
			case PID:
				// TODO travel = new
				break;
			case TAIL:
				// TODO travel = new
				break;
			case TAILCONTROL:
				// TODO travel = new
				break;
			case TAILDOWN:
				// TODO travel = new
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

		List<Detector> endDetectorList = createDetector(section.getEndCondition());
		List<Detector> abnormalDetectorList = createDetector(section.getAbnormalCondition());

		SectionSwitchingCondition switchCondition = new SectionSwitchingCondition(endDetectorList,
				abnormalDetectorList);
		return switchCondition;
	}

	/*
	 * 検知器リスト製造
	 */
	private static List<Detector> createDetector(Condition condition) {

		List<Detector> detectorList = new ArrayList<>();
		// TODO コース情報作成の都合上、一旦Sectionの判定条件はリストでなく単一所持にしている

		// for (Condition condition : conditionList) {
		Detector detector = null;
		switch (condition.getConditionType()) {
		case BLACK_DETECTION:
			break;
		case COLLISION_DETECTION:
			detector = new CollisionSensor(condition.getConditionValue());
			break;
		case DISTANCE:
			break;
		case GRAY_DETECTION:
			detector = new
			break;
		case OBSTACLES_DETECTION:
			break;
		case TAIL_ANGLE:
			break;
		case TIME:
			break;
		case WHITE_DURATION:
			break;
		default:
			break;
		}
		detectorList.add(detector);
		// }

		return detectorList;
	}

}