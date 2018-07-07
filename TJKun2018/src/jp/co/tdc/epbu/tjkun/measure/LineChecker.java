package jp.co.tdc.epbu.tjkun.measure;

import java.util.Timer;
import java.util.TimerTask;

import jp.co.tdc.epbu.tjkun.device.EV3Control;

public class LineChecker {

	private static EV3Control ev3Control;
	static int grayCount  = 0;

    public static void main(String[] args) {

    	final Timer timer = new Timer();
    	timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
        	lineCheck();
            }
        },0,50000);

        // 0.5秒待つ
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
    }

	public LineChecker(EV3Control ev3Control) {
		LineChecker.ev3Control = ev3Control;
	}

	public static boolean lineCheck() {
		boolean lineCheck = false;
		float brightness = ev3Control.getBrightness();
		 /* 通常走行時の誤検知を防ぐために、
		  * 灰色マーカー輝度値が一定回数検知されたら灰色検知を検知したとみなす
		  */
		if (brightness > 0.1) {
			if (grayCount > 4){
				lineCheck = true; // ラインチェック
			}
		} else {
			grayCount = 0;
			lineCheck = false;
		}
		return lineCheck;
	}

}