/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import java.util.List;

import jp.co.tdc.epbu.tjkun.measure.Detector;

/**
 * @author t2011002
 *
 */
public class SectionSwitchingCondition {

	private List<Detector> endDetectorList;
	private List<Detector> abnormalDetectorList;

	public SectionSwitchingCondition(List<Detector> endDetectorList, List<Detector> abnormalDetectorList) {
		this.endDetectorList = endDetectorList;
		this.abnormalDetectorList = abnormalDetectorList;
	}

	public boolean notifyEndCondition() {
		return true;
	}

	public boolean notifyAbnormalCondition() {
		return true;
	}

}
