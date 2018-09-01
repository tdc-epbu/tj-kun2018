/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import java.util.List;

import jp.co.tdc.epbu.tjkun.section.Course;
import jp.co.tdc.epbu.tjkun.section.Section;
import lejos.hardware.Sound;

/**
 * @author Takayuki
 *
 */
public class CourceFactory {

	public static Course create(CourceType courceType){

		List<Section> sectionList;

		switch (courceType) {
		case LEFT:
			//スタートダッシュ
			sectionList = Start.createStart();
			Sound.beep();

			//Leftコース攻略
			sectionList = LeftCource.createLeftCource();
			Sound.beep();

			//LookUpGate攻略
			sectionList.addAll(LookUpGate.createGateCource());
			Sound.beep();

			break;
		case RIGHT:
			//スタートダッシュ
			sectionList = Start.createStart();

			//Rightコース攻略
			sectionList.addAll(RightCource.createRightCource());

			//Rightコース攻略
			sectionList.addAll(Seesaw.createSeesaw());

			break;
//		case GATE:
//			sectionList = LookUpGate.createGateCource();
//			break;
//		case SEESAW:
//			sectionList = createStairsCource();
//			break;
//		case STAIRS:
//			sectionList = createStairsCource();
//			break;
		default:
//			sectionList = LeftCource.createLeftCource();
			sectionList = null;
		}

		return new Course(sectionList);
	}

}
