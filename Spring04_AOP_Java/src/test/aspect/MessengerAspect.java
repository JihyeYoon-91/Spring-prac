package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessengerAspect {
	/*
	 * 1.리턴 type은 상관없다
	 * 2.메소드 명이 send로 시작하는 메소드
	 * 3.메소드에 전달되는 인자도 상관없다
	 * 
	 * 위의 3가지 조건을 모두 만족시키는 메소드에 아래의 aop가 적용된다.
	 */
	
	//(*send*(*))메소드 인자 한개 (* send*(*,*))메소드인자 두개  
	//(*send*(java.lang.String,test.dto.MemberDto)) 인자 두개이며 type은 (String,MemberDto)
	@Around("execution(* send*(..))") 
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		//aop가 적용된 메소드 수행직전		
		System.out.println("--수행이전--");
		
		//aop가 적용된 메소드에 전달된 인자를 Object[]로 얻어낼 수 있다.
		Object[] args=joinPoint.getArgs();
		
		//반복문 돌면서 찾고 싶은 type을 찾는다
		for(Object tmp:args) {
			if(tmp instanceof String) {//만일 String type이면  instanceof연산자 : 그 객체가 무슨 타입인지 알 수 있다.
				//원래 type으로 casting
				String msg=(String)tmp;
				System.out.println("aop에서 읽어낸 내용:"+msg);
				if(msg.contains("바보")) {
					System.out.println("바보라고 하기 없기!");
					return; //메소드를 여기서 종료시킨다.
				}
			}
		}
		
		//aop가 적용된 메소드 수행하고 리턴되는 값 받아오기(void면 null이다.)
		Object obj=joinPoint.proceed(); //joinpoing를 수행하라
		
		//aop가 적용된 메소드 리턴직후
		System.out.println("--수행직후--");
	}
	@Around("execution(String getMessage())")
	public Object around2(ProceedingJoinPoint joinPoint) throws Throwable {
		//aop가 적용된 메소드를 수행하고 리턴되는 값을 얻어낸다.
		Object obj=joinPoint.proceed();
		//리턴할 값을 조작하기
		obj="뭔 공부야 그냥 놀ㅈㅏ";
		//리턴되는 값을 다시 리턴해주기
		return obj;
	}
}
