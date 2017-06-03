package jp.co.tdc.epbu.tjkun.logger;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import jp.co.tdc.epbu.tjkun.device.EV3;

/**
 *  ログの出力を行うクラスです。
 *  単純に画面に出力するだけです。
 */
public class LogGet{

    public static void main(String[] args) {
    	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    	// 標準出力へログを出力するハンドラを追加します
    	// また標準出力エラーをさせないようにします
    	logger.addHandler(new StdOutHandler());
    	logger.setUseParentHandlers(false);
    	logger.setLevel(Level.ALL);

    	// EV3クラスをインスタンス化する。
    	// デバイスで取得した値を取得してログとして利用するため。

/**
 * デバイスから変数を受け取る方法が分からなかったので
 * 現状はデバッグ用の変数を使用してテストを行い、
 * 実装予定のロジックはコメント化してます・・・
 */

    	//デバイスから変数を取得するロジック実装予定
		EV3 ev3;
		EV3.getInstance();
    	String forward =  String.sampleGyro;


    	//デバッグ用ロジック
    	float Brightness = 0.1f;
    	int   GyroValue  = 1;
    	String LogBrightness = Float.toString(Brightness);
    	String LogGyroValue  = Integer.toString(GyroValue);

        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

        public void run() {
            // ログ出力
        	//
        	logger.info("ログ出力テスト：" + LogBrightness);
        	logger.info("ログ出力テスト：" + GyroValue);
            }
        },0,500);

        // 5秒待つ
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timer.cancel();
   	}
}