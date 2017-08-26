package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.DeviceFactory;
import lejos.utility.Stopwatch;

public class SectionRunActual {

	Stopwatch time = new Stopwatch();
	// 左回転数初期値
	int initLMotorCount;
	// 右回転数初期値
	int initRMotorCount;

	public SectionRunActual() {
	}

    private static SectionRunActual instance;

    public static SectionRunActual getInstance() {

        if (instance == null) {
            instance = new SectionRunActual();
        }

           return instance;
    }

	public void start(){
		time.reset();
		this.initLMotorCount  = DeviceFactory.getInstance().getDrivingWheel().getLMotorCount();
		this.initRMotorCount  = DeviceFactory.getInstance().getDrivingWheel().getRMotorCount();
	}

	/**
	 * 区間内左モーター回転数返却
	 */
	public int getSectionLMotorCount(){
		return DeviceFactory.getInstance().getDrivingWheel().getLMotorCount() - initLMotorCount;
	}

	/**
	 * 区間内右モーター回転数返却
	 */
	public int getSectionRMotorCount(){
		return DeviceFactory.getInstance().getDrivingWheel().getRMotorCount() - initRMotorCount;
	}

	public int getTime(){
		return time.elapsed();
	}
}

