/**
 * 
 */
package jp.co.tdc.epbu.tjkun.section;

/**
 * @author t2011002
 *
 */
public class Condition {

	private ConditionType conditionType;
	private float conditionValue;
	
	public Condition(ConditionType conditionType, float conditionValue){
		this.conditionType = conditionType;
		this.conditionValue = conditionValue;
	}

	public ConditionType getConditionType() {
		return conditionType;
	}

	public float getConditionValue() {
		return conditionValue;
	}
	
}
	
