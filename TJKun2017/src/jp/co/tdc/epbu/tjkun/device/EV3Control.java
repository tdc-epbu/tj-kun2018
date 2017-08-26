package jp.co.tdc.epbu.tjkun.device;

/**
 * EV3の制御と各種センサー値の取得を取りまとめたインターフェース
 *
 * @author Higashizono Syuhei
 *
 */
interface EV3Control extends BalancerControl, DrivingWheel, Tail, GyroSensor, UltrasonicSensor, LightSensor,
        TouchSensor, DirectControl, DeviceReset, DeviceControl, Runnable {


}
