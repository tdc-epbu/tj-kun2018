package jp.co.tdc.epbu.tjkun.ui;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import jp.co.tdc.epbu.tjkun.device.DeviceFactory;
import jp.co.tdc.epbu.tjkun.measure.Button;
import jp.co.tdc.epbu.tjkun.measure.Calibrater;
import jp.co.tdc.epbu.tjkun.measure.TouchStatus;
import jp.co.tdc.epbu.tjkun.sample.RemoteTask;
import jp.co.tdc.epbu.tjkun.section.CourceType;
import jp.co.tdc.epbu.tjkun.strategy.DriveStrategy;
import jp.co.tdc.epbu.tjkun.strategy.DriveStrategyImpl;
import jp.co.tdc.epbu.tjkun.strategy.Story;
import jp.co.tdc.epbu.tjkun.strategy.StoryFactory;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

/**
 * キャリブレーションを実行し走行戦略の判定処理を呼び出す
 *
 * @author TJ
 *
 */
public class start implements Runnable {

    private ScheduledExecutorService scheduler;

    private TJScheduler tjScheduler;

    private DeviceFactory deviceFactory;

    private DriveStrategy driveStrategy;

    private Story story;

    Button button;
    Calibrater calibrater;

    boolean endFlag;

    public static void main(String[] args) {

        start starti = new start();

        starti.control();

    }

    private start() {
        tjScheduler = TJScheduler.getInstance();
        deviceFactory = DeviceFactory.getInstance();

    }

    public void starter() {

        deviceFactory.getDirectControl().controlDirect(0, 0, 0);

        driveStrategy = new DriveStrategyImpl();

        //cource = CourceFactory.create(CourceType.LEFT);
        story = StoryFactory.create(CourceType.LEFT);

        // PIDDriver pidDriver = new PIDDriver(ev3, calibrater);

        LCD.drawString("Start Wait", 0, 3);
        while (button.touchStatus() != TouchStatus.Released) {
            Delay.msDelay(10);
        }

        deviceFactory.getDeviceControl().reset();
        Sound.beep();

        tjScheduler.addFuture(RemoteTask.getInstance(), 0, 500, TimeUnit.MILLISECONDS);

        // 尻尾を停止位置へ固定しスタート準備
        while (button.touchStatus() != TouchStatus.Released
                && !RemoteTask.getInstance().checkRemoteCommand(RemoteTask.REMOTE_COMMAND_START)) {
            deviceFactory.getDirectControl().controlDirect(0, 0, 96);
            Delay.msDelay(10);
        }

        // デバッグ用
        // while (button.touchStatus() != TouchStatus.Released) {
        // ev3.controlBalance(0, 0, 0);
        // Delay.msDelay(4);
        // }

        deviceFactory.getBalancerControl().controlBalance(2, 2, 90);
        Delay.msDelay(100);

        tjScheduler.addFuture(this, 0, 10, TimeUnit.MILLISECONDS);

        while (button.touchStatus() != TouchStatus.Released
                && !RemoteTask.getInstance().checkRemoteCommand(RemoteTask.REMOTE_COMMAND_STOP)) {
            Delay.msDelay(250);
        }

        // pidDriver.drive(80, 13600, 13600);

        // Todo：スタート準備完了後、走行戦略の判定処理を呼び出す
        // DriveStrategy drivestrategy = new DriveStrategyImpl();
        // drivestrategy.operate();

        while (button.touchStatus() != TouchStatus.Released
                && !RemoteTask.getInstance().checkRemoteCommand(RemoteTask.REMOTE_COMMAND_STOP)) {
            endFlag = lejos.hardware.Button.DOWN.isDown();
            Delay.msDelay(250);
        }

    }

    public void control() {

        // キャリブレーション実行

        try {

            this.calibrater = Calibrater.getInstance();
            while (this.calibrater.calibration()) {

            }

            while (true) {

                this.starter();

                if (endFlag) {
                    break;
                }

                LCD.clear();
            }

        } finally {

            tjScheduler.close();
            RemoteTask.getInstance().close();
            deviceFactory.getDeviceControl().close();

        }

    }

    @Override
    public void run() {
        try {
            driveStrategy.operate(story);

            //			while (true) {
            //				EV3.getInstance().controlDirect(0, 0, 90);
            //				Delay.msDelay(100);
            //			}
        } catch (InterruptedException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }

}
