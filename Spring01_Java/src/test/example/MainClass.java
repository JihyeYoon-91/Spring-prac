package test.example;

import test.mypac.TestWeapon;
import test.mypac.Weapon;
import test.mypac.WeaponImpl;

public class MainClass {
	public static void main(String[] args) {
			//useWeapon()메소드를 호출하는게 목적이라면?
			//필요한 type객체를 직접 생성해서
			WeaponImpl w1=new WeaponImpl();
			//메소드를 호출함으로써 목적을 달성한다.
			useWeapon(w1);
			
			TestWeapon w2=new TestWeapon();
			useWeapon(w2);
		}
		//Weapon(인터페이스) type을 전달해야 호출할 수 있는메소드
		public static void useWeapon(Weapon w) {
			w.attack();
		}
	
}
