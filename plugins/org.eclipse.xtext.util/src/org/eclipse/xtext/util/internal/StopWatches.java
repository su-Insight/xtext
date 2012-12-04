/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.internal;

import static com.google.common.collect.Maps.*;
import static java.util.Collections.*;

import java.util.Map;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class StopWatches {
	
	public interface StoppedTask {
		public void start();
		public void stop();
	}
	
	public static class StopWatchForTask implements StoppedTask {
		final static long notRunning = -1;
		
		private NumbersForTask numbers;
		private long lastStart = notRunning;
		
		StopWatchForTask(NumbersForTask numbers) {
			this.numbers = numbers;
		}
		
		public void start() {
			if (!isRunning())
				lastStart = System.currentTimeMillis();
		}
		
		public boolean isRunning() {
			return lastStart != notRunning;
		}
		
		public void stop() {
			if (isRunning()) {
				long currentTimeMillis = System.currentTimeMillis();
				numbers.addMilliseconds(currentTimeMillis - lastStart);
				numbers.increaseMeasurements();
			}
		}
	}
	
	public static class NumbersForTask {
		long milliseconds = 0;
		int numberOfMeasurements = 0;
		
		public long getMilliseconds() {
			return milliseconds;
		}
		
		public synchronized void addMilliseconds(long milliseconds) {
			this.milliseconds += milliseconds;
		}
		
		public int getNumberOfMeasurements() {
			return numberOfMeasurements;
		}
		
		public synchronized void increaseMeasurements() {
			this.numberOfMeasurements++;
		}
	}

	private static Map<String, NumbersForTask> data = newLinkedHashMap();
	private static boolean enabled = false;
	private static StoppedTask NULLIMPL = new StoppedTask() {
		public void start() {}
		public void stop() {}
	};
	
	public static StoppedTask forTask(String task) {
		if (!enabled)
			return NULLIMPL;
		synchronized (data) {
			NumbersForTask numbers = data.get(task);
			if (numbers == null) {
				numbers = new NumbersForTask();
				data.put(task, numbers);
			}
			return new StopWatchForTask(numbers);
		}
	}
	
	public static void setEnabled(boolean isEnabled) {
		enabled = isEnabled;
	}
	
	public static void resetAll() {
		synchronized (data) {
			data.clear();
		}
	}
	
	public static Map<String, NumbersForTask> allNumbers() {
		synchronized (data) {
			return unmodifiableMap(data);
		}
	}
	
}
