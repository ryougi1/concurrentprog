package todo;

import done.ClockInput;
import done.ClockOutput;
import se.lth.cs.realtime.semaphore.Semaphore;

public class SetTimeThread extends Thread {
	private ClockThread clock;
	private static ClockInput input;
	private static ClockOutput output;
	private static Semaphore sem;

	public SetTimeThread(ClockThread c, ClockInput i, ClockOutput o) {
		clock = c;
		input = i;
		output = o;
		sem = input.getSemaphoreInstance();
	}

	public void run() {
		int lastMode = -1;
		while (true) {
			sem.take();
			int mode = input.getChoice();
			
			if (mode == ClockInput.SET_TIME) {
				lastMode = ClockInput.SET_TIME;
				// sem.give();
			}
			
			if ((lastMode == ClockInput.SET_TIME) && (mode != ClockInput.SET_TIME)) {
				lastMode = mode;
				clock.setTime(input.getValue());
			}



		}
	}

}
