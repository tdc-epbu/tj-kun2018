/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

/**
 * @author Takayuki
 *
 */
public class DriveStrategyImpl implements DriveStrategy {

//	private Calibrater calibrater;

//	private Travel travel;
//	private Travel jaggy;
//	private Travel tail;
//	private Travel taildown;
//	private Travel tailControl;

	public DriveStrategyImpl() {
//
//		this.calibrater = calibrater;
//		travel = new TravelPidImpl(this.calibrater);
//		jaggy = new TravelJaggyImpl(this.calibrater);
//		tail = new TravelTailImpl(this.calibrater, 73);
//		taildown = new TravelTailDownImpl(this.calibrater);
//		tailControl = new TravelTailControlRun(this.calibrater, 90);


		//sw = new Stopwatch();
	}

	@Override
	public void operate(Story story) throws InterruptedException {

		for(Scenario scenario :story.getScenarioList()) {
			//Section section = cource.DecideSpeed();

			Thread.sleep(6);
			scenario.capture();
			//Delay.msDelay(10);
			Thread.sleep(6);

		}


	}

}
