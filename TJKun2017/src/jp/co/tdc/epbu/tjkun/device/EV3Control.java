package jp.co.tdc.epbu.tjkun.device;

/**
 * EV3の制御と各種センサー値の取得を取りまとめたインターフェース
 *
 * @author Higashizono Syuhei
 *
 */
public interface EV3Control extends BalancerControl, DrivingWheel,
        Tail, GyroSensor, UltrasonicSensor, LightSensor, TouchSensor {

    /**
     * 左右のモーターを直接制御します。
     *
     * @param left
     *            左モーターパワー
     * @param right
     *            右モーターパワー
     * @param tail
     *            尻尾の角度
     */
    public void controlDirect(int left, int right, int tail);


}
