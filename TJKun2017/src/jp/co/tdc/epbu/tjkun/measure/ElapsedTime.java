package jp.co.tdc.epbu.tjkun.measure;

public class ElapsedTime implements Detection {

	int elapsedTime = 0;

	public ElapsedTime(int elapsed) {
		this.elapsedTime = elapsed;
	}

	@Override
	public boolean Notify() {
		if (SectionRunActual.getInstance().getTime() > elapsedTime) {
			return true;
		} else {
			return false;
		}
	}

}
