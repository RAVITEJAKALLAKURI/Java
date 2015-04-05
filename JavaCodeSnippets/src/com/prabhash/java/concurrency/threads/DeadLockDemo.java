package com.prabhash.java.concurrency.threads;

/**
 * Program to create a Deadlock.
 * 
 * @author prrathore
 *
 */
public class DeadLockDemo {
	
	public synchronized void method1() {
		System.out.println(Thread.currentThread().getName() + " => Method 1");
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized void method2() {
		System.out.println(Thread.currentThread().getName() + " => Method 2");
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void method3() {
		System.out.println("Method3!!");
	}
	
	public synchronized void method4() {
		System.out.println("Method4!!");
	}

	public static void main(String[] args) {
		
		final DeadLockDemo monitorObj1 = new DeadLockDemo();
		final DeadLockDemo monitorObj2 = new DeadLockDemo();
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				monitorObj1.method1();
				monitorObj2.method3();
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				monitorObj2.method2();
				monitorObj1.method4();
			}
		});
		
		thread1.start();
		thread2.start();

	}

}
