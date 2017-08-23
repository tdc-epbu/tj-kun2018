/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import jp.co.tdc.epbu.tjkun.drive.Travel;
import jp.co.tdc.epbu.tjkun.drive.TravelJaggyImpl;
import jp.co.tdc.epbu.tjkun.drive.TravelPidImpl;
import jp.co.tdc.epbu.tjkun.drive.TravelTailControlRun;
import jp.co.tdc.epbu.tjkun.drive.TravelTailDownImpl;
import jp.co.tdc.epbu.tjkun.drive.TravelTailImpl;
import jp.co.tdc.epbu.tjkun.measure.Calibrater;

/**
 * @author Takayuki
 *
 */
public class DriveStrategyImpl implements DriveStrategy {

	private Calibrater calibrater;

	private Travel travel;
	private Travel jaggy;
	private Travel tail;
	private Travel taildown;
	private Travel tailControl;

	public DriveStrategyImpl(Calibrater calibrater) {

		this.calibrater = calibrater;
		travel = new TravelPidImpl(this.calibrater);
		jaggy = new TravelJaggyImpl(this.calibrater);
		tail = new TravelTailImpl(this.calibrater, 73);
		taildown = new TravelTailDownImpl(this.calibrater);
		tailControl = new TravelTailControlRun(this.calibrater, 90);


		//sw = new Stopwatch();
	}

	@Override
	public void operate(Story story) throws InterruptedException {

		for(Scenario scenario :story.getScenarioList()) {
			//Section section = cource.DecideSpeed();

			Thread.sleep(6);
			scenario.capture();
			Thread.sleep(8);

		}


	}

}
