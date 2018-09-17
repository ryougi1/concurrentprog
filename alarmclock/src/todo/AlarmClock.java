package todo;

import done.*;
import se.lth.cs.realtime.semaphore.Semaphore;

public class AlarmClock extends Thread {

	private static ClockInput input;
	private static ClockOutput output;
	private static Semaphore sem;
	private ClockThread clock;
	private SetTimeThread setTimeThread;
	private SetAlarmThread setAlarmThread;

	public AlarmClock(ClockInput i, ClockOutput o) {
		input = i;
		output = o;
		sem = input.getSemaphoreInstance();
	}

	// The AlarmClock thread is started by the simulator. No
	// need to start it by yourself, if you do you will get
	// an IllegalThreadStateException. 
	
	public void run() {
		ClockThread clock = new ClockThread(output);
		clock.start();
		SetTimeThread setTimeThread = new SetTimeThread(clock, input, output);
		setTimeThread.start();
		
		while (true) {
			
		}
	}
}