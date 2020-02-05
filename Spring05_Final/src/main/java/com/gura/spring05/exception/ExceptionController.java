package com.gura.spring05.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/*
 *  Exception 이 발생했을 때 처리하는 컨트롤러 만들기
 *  
 *  - @ControllerAdvice 어노테이션을 클래스에 붙인다.
 *  
 *  - 메소드에 @ExceptionHandler(예외 class type) 을 붙여서 예외를 처리한다.
 */
@ControllerAdvice
public class ExceptionController {
	//CanNotDeleteException type의 예외가 발생하면 호출되는 메소드	
   @ResponseStatus(HttpStatus.FORBIDDEN) //브라우저에서 네트워크의 응답상태도 정상상태가 아닌 예외상태로 표기해준다.
   @ExceptionHandler(CanNotDeleteException.class)
   public ModelAndView conNotDelete() {
      
      ModelAndView mView=new ModelAndView();
      mView.addObject("msg", "남의 파일 지우면 혼난다~");
      mView.setViewName("error/forbidden");
      return mView;
   }
}
