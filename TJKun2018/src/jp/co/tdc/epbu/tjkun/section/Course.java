/**
 *
 */
package jp.co.tdc.epbu.tjkun.section;

import java.util.List;

import lejos.hardware.Sound;

/**
 * @author Takayuki
 *
 */
public class Course {

	private List<Section> sectionList;

	private int driveSection = 0;


	public Course(){
	}

	public Course(List<Section> sectionList){
		this.sectionList = sectionList;
		sectionList.get(driveSection).startMeasure();
	}

	/**
	 * 速度を決定する
	 * @return
	 */
	public Section DecideSpeed(){


//		if(sectionList.get(driveSection).judgeAbnormal()){
//			updateSection();
//		}
		
		if(sectionList.get(driveSection).judgeEndOfSection()){
			updateSection();
		}

		return sectionList.get(driveSection);
	}

	/**
	 * 走行中か判定する
	 * @return
	 */
	public boolean isDriving(){

		if(sectionList.size() > driveSection){
			return true;
		}
		return false;
	}

	/**
	 * 次区間に切り替える
	 */
	private void updateSection(){

		driveSection++;

		Sound.beep();
		sectionList.get(driveSection).startMeasure();
	}
	
}
