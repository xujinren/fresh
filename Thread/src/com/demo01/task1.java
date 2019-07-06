package com.demo01;

class task01 extends Thread{
	public void run(){
		int i = 0;
		for(; i < 10; i ++){
			try {
				this.sleep(500);
				System.out.println("不！诸葛亮最帅！");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class task1 extends Thread{
	public void run(){
		int i;
		for(i = 0; i < 10; i ++){
			try {
				this.sleep(500);
				System.out.println("超崽最帅!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		task1 t1 = new task1();
		task01 t2 = new task01();
		/*t1.setPriority(9);
		t2.setPriority(2);*/
		t1.start();
		t2.start();
	}
	public task1() {
		// TODO Auto-generated constructor stub
	}

}
