/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import java.util.List;

import jp.co.tdc.epbu.tjkun.measure.Detection;

/**
 * @author t2011002
 *
 */
public class SectionSwitchingCondition {

	private List<Detection> endDetectorList;
	private List<Detection> abnormalDetectorList;

	public SectionSwitchingCondition(List<Detection> endDetectorList, List<Detection> abnormalDetectorList) {
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
