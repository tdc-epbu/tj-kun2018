package jp.co.tdc.epbu.tjkun.drive;

public class WheelSpeed {
	private int wheelSpeedScaleLeft;
	private int wheelSpeedScaleRight;
	private int turnSpeedScale;

	public WheelSpeed (int wheelSpeedScaleLeft, int wheelSpeedScaleRight){
		this.wheelSpeedScaleLeft = wheelSpeedScaleLeft;
		this.wheelSpeedScaleRight = wheelSpeedScaleRight;
	}

	public WheelSpeed (int wheelSpeedScaleLeft, int wheelSpeedScaleRight, int turnSpeedScale){
		this.wheelSpeedScaleLeft = wheelSpeedScaleLeft;
		this.wheelSpeedScaleRight = wheelSpeedScaleRight;
		this.turnSpeedScale = turnSpeedScale;
	}
	public int getWheelSpeedScaleLeft() {
		return wheelSpeedScaleLeft;
	}
	public void setWheelSpeedScaleLeft(int wheelSpeedScaleLeft) {
		this.wheelSpeedScaleLeft = wheelSpeedScaleLeft;
	}
	public int getWheelSpeedScaleRight() {
		return wheelSpeedScaleRight;
	}
	public void setWheelSpeedScaleRight(int wheelSpeedScaleRight) {
		this.wheelSpeedScaleRight = wheelSpeedScaleRight;
	}
	public int getTurnSpeedScale() {
		return turnSpeedScale;
	}

}
