/**
 *
 */
package jp.co.tdc.epbu.tjkun.section;

import java.util.List;

/**
 * @author Kakuta
 *
 */
public class Area {

	private List<Section> sectionList;
	private AreaType areaType;

	public Area(List<Section> sectionList, AreaType areaType) {
		this.sectionList = sectionList;
		this.areaType = areaType;
	}

	/**
	 * @return sectionList
	 */
	public List<Section> getSectionList() {
		return sectionList;
	}
	/**
	 * @param sectionList セットする sectionList
	 */
	public void setSectionList(List<Section> sectionList) {
		this.sectionList = sectionList;
	}
	/**
	 * @return areaType
	 */
	public AreaType getAreaType() {
		return areaType;
	}
	/**
	 * @param areaType セットする areaType
	 */
	public void setAreaType(AreaType areaType) {
		this.areaType = areaType;
	}
}
