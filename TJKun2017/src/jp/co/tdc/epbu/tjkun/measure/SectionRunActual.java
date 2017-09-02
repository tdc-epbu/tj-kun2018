package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.EV3Control;
import jp.co.tdc.epbu.tjkun.section.Condition;
import lejos.utility.Stopwatch;

public class SectionRunActual {

	private EV3Control ev3Control;

	Stopwatch time = new Stopwatch();
	int initMotorCount;

	public SectionRunActual(EV3Control ev3Control) {
		this.ev3Control = ev3Control;
	}

	public boolean notify(Condition condition){
		boolean notify = false;
		switch (condition.getConditionType()){
		case DISTANCE:
			// 回転数
			int motorCount = Math.abs(ev3Control.getLMotorCount() - initMotorCount);
			if (condition.getConditionValue() <= motorCount) {
				notify = true;
			}
			break;
		case TIME:
			// 時間
			if (condition.getConditionValue() <= time.elapsed()) { // 時間の基準はチューニングする必要あり
				notify = true;
			}
			break;
		case OBSTACLES_DETECTION:
			// 障害物検知
			if (condition.getConditionValue() < ev3Control.getSonarDistance()) {
				return true;
			}
			break;
		case TAIL_ANGLE:
			// しっぽ角度
			if (condition.getConditionValue() >= ev3Control.getTailAngle()) {
				return true;
			}
			break;
		case BLACK_DETECTION:
			// 黒色検知
			if (condition.getConditionValue() >=  ev3Control.getBrightness()) {
				return true;
			}
			break;
		case GRAY_DETECTION:
			// 灰色検知
			int grayCount = 0;
			if (condition.getConditionValue() <= ev3Control.getBrightness()) {
				grayCount++;
			} else {
			grayCount = 0;
			}
			if (grayCount > 4){
				return true;
			}
			break;
		case CONFLICT_DETECTION:
			// 衝突検知
			if (condition.getConditionValue() <= ev3Control.getGyroValue()) {
				notify = true;
			}
			break;
		}
		return notify;
	}
	public void start(){

		time.reset();
		this.initMotorCount  = ev3Control.getLMotorCount();

	}
}

