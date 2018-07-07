package jp.co.tdc.epbu.tjkun.sample;

public interface Driveable {

	/**
	 * 左右のモーターの回転数がいずれかの値を超えるまで「speed」の値で走行します。
	 * @param speed
	 * @param leftMotorCount
	 * @param rightMotorCount
	 */
	public void drive(int speed, int leftMotorCount, int rightMotorCount);
}
