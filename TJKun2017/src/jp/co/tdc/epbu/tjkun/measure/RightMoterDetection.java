package jp.co.tdc.epbu.tjkun.measure;

public class RightMoterDetection implements Detection{

	int rightMoterDetection = 0;

	public RightMoterDetection(int rightMoter) {
		this.rightMoterDetection = rightMoter;
	}

	@Override
	public boolean Notify() {
		if (SectionRunActual.getInstance().getSectionRMotorCount() > rightMoterDetection) {
			return true;
		} else {
			return false;
		}
	}
}

