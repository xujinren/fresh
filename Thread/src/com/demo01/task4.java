package com.demo01;

import java.util.concurrent.SynchronousQueue;

public class task4 {
	public static Integer count  = new Integer(10);
	public static void main(String[] args) {
		Producer p1 = new Producer();
		Consumer c1 = new Consumer();
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(c1);
		t1.start();
		t2.start();
		
	}
	
}

class Producer implements Runnable{
	
	public void run(){
		while(true){
			synchronized (task4.count) {
				if(task4.count.intValue() >= 100){
					try {
						Thread.currentThread().wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					show();
				}
			}
			
		}
	}
	public void show(){
		System.out.println("生产者生产一个产品，生产前有"+task4.count+";生产后有：" + (task4.count + 1));
		task4.count++;
		Thread.currentThread().notify();
	}
}
class Consumer implements Runnable{
	public void run(){
		while(true){
			synchronized (task4.count) {
				if(task4.count.intValue() <= 0){
					try {
						Thread.currentThread().wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					show();
				}
			}
		}
	}

	private void show() {
		System.out.println("消费者消费一个产品，消费前有" + task4.count + "; 消费后：" + (task4.count--));
		task4.count--;
		Thread.currentThread().notifyAll();
	}
}