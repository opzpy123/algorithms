package competeTest.obj;

import lombok.Data;

//@Data
public class Person {
	private String name="张三";
	private void showName(){
		System.out.println(name);
	}

	public void show(){
		System.out.println(123);
	}
}
