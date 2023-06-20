package org.kosta.icandoit.controller;

/**
 * FrontControllerServlet(공통정책담당) 과 Controller (개별 컨트롤러 로직담당)를 <br>
 * 연결하는 역할<br>
 * Reflection API를 통해 Front 에서 전달하는 command에 따라 런타임시에<br>
 * 동적으로 컨트롤러 객체를 생성해 Front 에 리턴한다.<br>
 * 
 * HandlerMapping 은 시스템 상에 단 한번 생성해서 공유해 사용하면 되므로<br>
 * Singleton Design Pattern을 사용한다.<br>
 * 
 * @author USER
 *
 */
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {
	}

	public static HandlerMapping getInstance() {
		return instance;
	}

	public Controller create(String command)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		StringBuilder classInfo = new StringBuilder(this.getClass().getPackage().getName());
		classInfo.append(".").append(command).append("Controller");
		return (Controller) Class.forName(classInfo.toString()).newInstance();
	}
}
