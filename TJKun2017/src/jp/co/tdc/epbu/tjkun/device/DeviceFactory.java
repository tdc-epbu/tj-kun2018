package jp.co.tdc.epbu.tjkun.device;

import java.util.concurrent.TimeUnit;

import jp.co.tdc.epbu.tjkun.ui.TJScheduler;

public class DeviceFactory {

    private EV3Control ev3;

    private DeviceFactory() {

        ev3 = EV3.getInstance();

        TJScheduler.getInstance().addFuture(ev3, 0, 4, TimeUnit.MILLISECONDS);
    }

    public static DeviceFactory getInstance() {

        if (instance == null) {
            instance = new DeviceFactory();
        }
        return instance;
    }

    private static DeviceFactory instance;

    public DrivingWheel getDrivingWheel() {
        return ev3;
    }

    public LightSensor getLightSensor() {
        return ev3;
    }

    public Tail getTail() {
        return ev3;
    }

    public UltrasonicSensor getUltrasonicSensor() {
        return ev3;
    }

    public TouchSensor getTouchSensor() {
        return ev3;
    }

    public BalancerControl getBalancerControl() {
        return ev3;
    }

    public GyroSensor getGyroSensor() {
        return ev3;
    }

    public DirectControl getDirectControl() {
        return ev3;
    }

    public DeviceControl getDeviceControl() {
        return ev3;
    }
}
