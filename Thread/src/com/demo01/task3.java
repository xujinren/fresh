package com.demo01;

public class task3 {
	public static void main(String[] args) {
		task03 t = new task03();
		
		Thread th1 = new Thread(t, "窗口1");
		Thread th2 = new Thread(t, "窗口2");
		Thread th3 = new Thread(t, "窗口3");
		Thread th4 = new Thread(t, "窗口4");
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}
}

class task03 implements Runnable{
	public  int count =100;
	public void run(){
		while(true){
			synchronized(this.getClass()){
				if(count > 0){
					show();
				}else{
					return ;
					
				}
				
			}
			
		}
		
	}
	
	public  void show(){
			System.out.println(Thread.currentThread().getName() + "卖出第" + (100 - count + 1) + "张票");
				count -- ;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	
}
