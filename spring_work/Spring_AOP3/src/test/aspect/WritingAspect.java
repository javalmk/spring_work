package test.aspect;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WritingAspect {
	
	
	@Before("execution(public void write*())")
	public void preparePen(){
		System.out.println("펜을 준비해서 뚜껑을 열어요");
	}
	@After("execution(public void write*())")
	public void endPen(){
		System.out.println("펜의 뚜껑을 닫고 정리를 해요");
	}
	/*
	 *  ProcedingJoinPoint 객체는  @Around 에서만 지원된다. 
	 */
	@Around("execution(public void *ToTeacher(*))")
	public void aroundPen(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Pen 준비"); //Before
		
		//Aop 가 적용된 메소드에 전달된 인자를 배열로 얻어오기
		Object[] args=joinPoint.getArgs();
		for(Object tmp:args){
			//만일 객체가 String type 이라면
			if(tmp instanceof String){
				String name=(String)tmp; //casting
				System.out.println("메소드에 전달된 name:"+name);
			}
		}
		
		joinPoint.proceed(); //핵심 로직 수행
		
		System.out.println("Pen 마무리");//After
		
	}
	
	@Around("execution(public java.util.Map *ToMother())")
	public Object aroundMother(ProceedingJoinPoint joinPoint) throws Throwable{
		
		Object obj=joinPoint.proceed();
		//리턴된 객체가 Map type 이라면 
		if(obj instanceof Map){
			//원래 type 으로 casting 해서 
			Map<String, Object> map=(Map)obj;
			//Map 에 저장된 데이터 읽어와 보기 
			String msg=(String)map.get("msg");
			System.out.println("msg:"+msg);
			//Map 에 저장된 데이터 수정하기
			map.put("msg", "안녕 엄마~");
		}
		return obj;
	}
	
}































