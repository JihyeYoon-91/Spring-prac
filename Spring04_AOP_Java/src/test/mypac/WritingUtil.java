package test.mypac;

import org.springframework.stereotype.Component;
/*
 * [bean이 된다.]
 * -해당 클래스로 객체가 생성이되고 스프링bean컨테이너에서 관리가 된다.
 */
//@Componet어노테이션을 붙여놓으면 컴포넌트 스캔을 했을 때 bean이된다.
@Component
public class WritingUtil {
	public void write1() {
		System.out.println("편지를 써요");
	}
	public void write2() {
		System.out.println("일기를 써요");
	}
	public void write3() {
		System.out.println("소설을 써요");
	}
}
