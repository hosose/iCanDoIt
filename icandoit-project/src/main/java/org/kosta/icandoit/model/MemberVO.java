package org.kosta.icandoit.model;

import java.io.Serializable;

/**
 * WAS 는 reloading 시에 (java code 수정시) <br>
 * session 정보를 파일에 직렬화하여 저장한 후 다시 load 가 되면<br>
 * 역직렬화해서 session 정보를 복원한다.<br>
 * 만약 session의 attribute 에 MemberVO 와 같은 인증 정보가 존재하면<br>
 * 해당 클래스도 직렬화 되기 위해 implements Serializalble 해서 함께 외부 전송될 수 있도록 한다. <br>
 * => 개발 단계에서 자바 코드가 수정되어 WAS reload되어도 로그인 해제되지 않고<br>
 * 계속 유지되는 상태로 개발을 계속 진행할 수 있다
 * 
 * 운영시에는 서버 프로그램 수정 후 리로드 시에 사용자 정보를 유지할 수 있다.
 */
public class MemberVO implements Serializable {
	private static final long serialVersionUID = -3972768952288329070L;
	private String id;
	private String password;
	private String address;
	private String phone;
	private String nickName;
	private String name;

	public MemberVO() {
		super();
	}

	public MemberVO(String id, String password, String address, String phone, String nickName, String name) {
		super();
		this.id = id;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.nickName = nickName;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", address=" + address + ", phone=" + phone
				+ ", nickName=" + nickName + ", name=" + name + "]";
	}
}
