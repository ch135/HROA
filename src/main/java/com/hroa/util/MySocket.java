package com.hroa.util;

import java.net.Socket;

public class MySocket implements Comparable<MySocket>{

	private Integer num;
	private Socket socket;
	
	@Override
	public int compareTo(MySocket o) {
		return 0;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	

}
