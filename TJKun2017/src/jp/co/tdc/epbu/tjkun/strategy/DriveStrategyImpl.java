/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import jp.co.tdc.epbu.tjkun.drive.Travel;
import jp.co.tdc.epbu.tjkun.drive.TravelJaggyImpl;
import jp.co.tdc.epbu.tjkun.drive.TravelPidImpl;
import jp.co.tdc.epbu.tjkun.drive.TravelSpinImpl;
import jp.co.tdc.epbu.tjkun.measure.Calibrater;
import jp.co.tdc.epbu.tjkun.section.Course;
import jp.co.tdc.epbu.tjkun.section.Section;

/**
 * @author Takayuki
 *
 */
public class DriveStrategyImpl implements DriveStrategy {

	private Calibrater calibrater;

	private Travel travel;
	private Travel jaggy;
	private Travel spin;
	private Travel balance;
	private Travel direct;

	public DriveStrategyImpl(Calibrater calibrater) {

		this.calibrater = calibrater;
		travel = new TravelPidImpl(this.calibrater);
		jaggy = new TravelJaggyImpl(this.calibrater);
		spin = new TravelSpinImpl(this.calibrater);
		balance = new TravelBalanceImpl(this.calibrater);
		direct = new TravelDirectImpl(this.calibrater);


		//sw = new Stopwatch();
	}

	@Override
	public void operate(Course cource) throws InterruptedException {

		while (true) {

			Section section = cource.DecideSpeed();


			if (section.getTravelType().equals(TravelType.END)) {
				break;
			}
			Thread.sleep(6);
			//Delay.msDelay(6);


			switch (section.getTravelType()) {
			case PID:
				travel.travel(section.getWheelspeed(),section.getTail());
				break;
			case JAGGY:
				jaggy.travel(section.getWheelspeed(),section.getTail());
				break;
			case SPIN:
				spin.travel(section.getWheelspeed(),section.getTail());
				break;
			case BALANCE:
				balance.travel(section.getWheelspeed(),section.getTail());
				break;
			case DIRECT:
				direct.travel(section.getWheelspeed(),section.getTail());
				break;
			default:
			}
			Thread.sleep(8);
			//Delay.msDelay(8);

			//EV3.getInstance().run();

		}
	}

}
