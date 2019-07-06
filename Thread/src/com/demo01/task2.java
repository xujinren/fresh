package com.demo01;

import javax.swing.plaf.SliderUI;

public class task2{
	public static void main(String[] args) {
		WashOps wp = new WashOps();
		WashBol wb = new WashBol();
		Thread t1 = new Thread(wp);
		Thread t2 = new Thread(wb);
		t1.setName("洗杯子线程");
		t2.setName("烧水线程");
		
		
		try {
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			System.out.println("开始泡茶...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}

class WashOps implements Runnable{

	@Override
	public void run() {
		System.out.println("开始洗杯子");
		int i;
		for(i = 0; i  < 10; i++){
			System.out.println(Thread.currentThread().getName() + "开始洗第" + (i + 1) +"个杯子");
			try {
				Thread.sleep(500);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("杯子洗完了");
	}
	
}


class WashBol implements Runnable{
	@Override
	public void run() {
		System.out.println("烧水开始");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}