/**
 *
 */
package jp.co.tdc.epbu.tjkun.section;

import java.util.List;

/**
 * @author Takayuki
 *
 */
public class Course {

	private List<Area> areaList;

	public Course(){
	}

	public Course(List<Area> areaList){
		this.areaList = areaList;
		//areaList.get(driveSection).startMeasure();
	}

	/**
	 * @return areaList
	 */
	public List<Area> getAreaList() {
		return areaList;
	}

	/**
	 * @param areaList セットする areaList
	 */
	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

//	/**
//	 * 速度を決定する
//	 * @return
//	 */
//	public Section DecideSpeed(){
//
//
////		if(sectionList.get(driveSection).judgeAbnormal()){
////			updateSection();
////		}
//
//		if(sectionList.get(driveSection).judgeEndOfSection()){
//			updateSection();
//		}
//
//		return sectionList.get(driveSection);
//	}
//
//	/**
//	 * 走行中か判定する
//	 * @return
//	 */
//	public boolean isDriving(){
//
//		if(sectionList.size() > driveSection){
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * 次区間に切り替える
//	 */
//	private void updateSection(){
//
//		driveSection++;
//
//		Sound.beep();
//		sectionList.get(driveSection).startMeasure();
//	}

}
