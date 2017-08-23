package jp.co.tdc.epbu.tjkun.ui;

import java.util.concurrent.ScheduledExecutorService;

public class TJScheduler {

	private TJScheduler(){

	}

	private static TJScheduler instance;


	private ScheduledExecutorService scheduler;

	public static TJScheduler getInstance() {

		if(instance == null ) {
			instance = new TJScheduler();
		}


		return instance;
	}


}
