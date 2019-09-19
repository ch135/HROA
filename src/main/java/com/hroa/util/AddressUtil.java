package com.hroa.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.hroa.controller.ShUserController;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class AddressUtil {

	public static JSONArray area;

	static {
		String path = ShUserController.class.getClassLoader().getResource("areaCode.json").getPath();
		area = getJsonObject(path);
	}

	// 根据读取到的string创建json对象
	private static JSONArray getJsonObject(String fileName) {
		JSONArray array = null;
		String jsonStr = getJsonStr(fileName);
		if (jsonStr != null) {
			try {
				array = JSONArray.fromObject(jsonStr);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return array;
	}

	// 从文件读取jsonstr
	private static String getJsonStr(String fileName) {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			String line;
			while ((line = bf.readLine()) != null) {
				stringBuilder.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	public static String[] getProvince(String address) {
		String[]data=new String[3];
		JSONObject province;
		for (int i = 0; i < area.size(); i++) {
			province = area.getJSONObject(i);
			if(province.getString("areaCode").equals(address)){
				System.out.println(province);
				data[0]=province.getString("province").replace("省", "");
				data[1]=province.getString("city").replace("市", "");
				data[2]=province.getString("district").replace("市", "").replace("区", "").replace("县", "");
				break;
			}
		}
		return data;
	}

}
