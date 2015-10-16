/**
 * COPYRIGHT (C) 2014 Inventron Inc. All Rights Reserved.
 * 
 */
package org.embedded.beaglebone.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author a168814
 * JobController.java added on May 10, 2014 9:52:34 PM
 */
public class JobController {

	private static final int DEFAULT_NUMBER_OF_THREADS = 5;
	private int NTHREADS = 4;
	private ExecutorService executorService;
	private static JobController defaultExecutor = new JobController(DEFAULT_NUMBER_OF_THREADS, true);
	
	public JobController(int numberOfThreads){
		if(numberOfThreads>0)
			NTHREADS = numberOfThreads;
		executorService = Executors.newFixedThreadPool(NTHREADS);
	}
	
	public JobController(int numberOfThreads, boolean scheduler){
		if(numberOfThreads>0)
			NTHREADS = numberOfThreads;
		if(scheduler) {
			executorService = Executors.newScheduledThreadPool(NTHREADS);
		} else {
			executorService = Executors.newFixedThreadPool(NTHREADS);
		}
	}
	
	public void submitJob(Runnable job){
		if(executorService != null) {
			executorService.submit(job);
		}
	}
	
	public void schedule(Runnable command, long delay, TimeUnit unit) {
		if(executorService instanceof ScheduledExecutorService) {
			((ScheduledExecutorService)executorService).schedule(command, delay, unit);
		}
	}
	
	public void scheduleAtFixedRate(Runnable command, long delay, long period, TimeUnit unit) {
		if(executorService instanceof ScheduledExecutorService) {
			((ScheduledExecutorService)executorService).scheduleAtFixedRate(command, delay, period, unit);
		}
	}
	
	public int getActiveThreadCount(){
		if(executorService instanceof ThreadPoolExecutor){
			return ((ThreadPoolExecutor) executorService).getActiveCount();
		}
		else return -1;
	}
	
	public static JobController getDefaultJobController(){
		return defaultExecutor;
	}
	
	public static void setCurrentThreadName(String name) {
		Thread.currentThread().setName(name);
	}
	
	public ExecutorService getExecutorService() {
		return executorService;
	}
}
