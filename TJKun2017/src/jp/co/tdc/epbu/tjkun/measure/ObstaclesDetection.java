package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.DeviceFactory;

public class ObstaclesDetection implements Detection{

	int obstaclesDetection = 0;

	public ObstaclesDetection(int obstacles) {
		this.obstaclesDetection = obstacles;
	}

	@Override
	public boolean Notify() {
		if (DeviceFactory.getInstance().getUltrasonicSensor().getSonarDistance() >  obstaclesDetection) {
			return true;
		} else {
			return false;
		}
	}

}

