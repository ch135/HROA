package com.hroa.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import com.hroa.model.Message;

/**
 * @author Administrator
 */

public class ServerTool {
	public static ServerSocket server = null;
	public static HashMap<Integer, Socket> socketList = new HashMap<Integer, Socket>();
	public static Socket[] list = new Socket[300];

	public static List<Integer> getNum() {
		List<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < 300; i++) {
			if(list[i]!=null){
				arrayList.add(i);
			}
		}
		return arrayList;
	}

	public static void connection() throws IOException {
		server = new ServerSocket(8081);
		check();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Socket socket = server.accept();
						putSocket(socket);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	}

	// 设置socket编号
	public static void putSocket(Socket socket) throws SocketException {
		int count = 0;
		while (list[count] != null)
			count++;
		socket.setKeepAlive(true);
		socket.setOOBInline(true);
		try {
			PrintStream printStream = new PrintStream(socket.getOutputStream(), true, "UTF-8");
			printStream.println(count + "");
			printStream.flush();
			list[count] = socket;
			System.out.println("加入socket:" + count);
		} catch (Exception e) {
			System.out.println("连接socket出错");
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	public static Message getMessage(Integer num) {
		Message message = null;
		System.out.println(list);
		Socket socket = list[num];
		try {
			if (socket != null) {
				message = null;
				InputStream stream = socket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
				PrintStream printStream = new PrintStream(socket.getOutputStream(), true, "UTF-8");
				printStream.flush();
				printStream.println("get");
				printStream.flush();
				String line = reader.readLine();
				System.out.println(line);
				message = (Message) JSONObject.toBean(JSONObject.fromObject(line), Message.class);
			}
		} catch (Exception e) {
			try {
				if (socket.isConnected()) {
					socket.close();
				}
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
			System.out.println(e.getMessage());
		}
		return message;
	}

	public static void check() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					for (int i = 0; i < list.length; i++) {
						try {
							Socket socket = list[i];
							if (socket != null)
								socket.sendUrgentData(0xFF);
						} catch (IOException e) {
							list[i] = null;
							System.out.println("socket客户端关闭");
						}
					}
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

}
