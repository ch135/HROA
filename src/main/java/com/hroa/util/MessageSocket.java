package com.hroa.util;

import java.net.Socket;


public class MessageSocket extends Thread {
	private Socket socket;
	private Integer number;
	public MessageSocket(Socket socket, Integer number) {
		super();
		this.socket = socket;
		this.number = number;
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
//	BufferedReader reader;
//	PrintStream printStream;
//	public SocketThread(Socket socket) {
//		this.socket=socket;
//	}
//	@Override
//	public void run() {
//		try {
//			reader = new BufferedReader(new InputStreamReader( socket.getInputStream(), "UTF-8"));
//			printStream = new PrintStream( socket.getOutputStream(), true, "UTF-8");
//			printStream.println("test");
//			String line;
//			while((line = reader.readLine())!=null){
//				System.out.println(line);
//			}
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		super.run();
//	}
}
