package jp.co.tdc.epbu.tjkun.measure;

public class LeftMoterDetection implements Detection{

	int leftMoterDetection = 0;

	public LeftMoterDetection(int leftMoter) {
		this.leftMoterDetection = leftMoter;
	}

	@Override
	public boolean Notify() {
		if (SectionRunActual.getInstance().getSectionLMotorCount() > leftMoterDetection) {
			return true;
		} else {
			return false;
		}
	}
}

