package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.DeviceFactory;
import jp.co.tdc.epbu.tjkun.device.TouchSensor;


public class Button {

	private boolean pressStatus;

    private TouchSensor touchSensor;


	public Button() {
		this.touchSensor = DeviceFactory.getInstance().getTouchSensor();
	}

	public TouchStatus touchStatus() {


		if (touchSensor.touchSensorIsPressed()) {
			pressStatus = true; // タッチセンサーが押された
			return TouchStatus.Pressed;
		} else {
			if (pressStatus) {
				pressStatus = false; // タッチセンサーが押された後に放した
				return TouchStatus.Released;
			}
		}

		return TouchStatus.NotPressed;
	}

}
