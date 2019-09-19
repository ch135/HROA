package com.hroa.util;
public class CalcPageUtils {
	public static int totalPage(int pageSize,int totalCount){
		int totalPage=0;//总共页数
		//int intgNumber=0;//整页数
		int remderNumber=0;//剩余数量
		totalPage=totalCount/pageSize;//取整
		remderNumber=totalCount%pageSize;//取余
		if(remderNumber!=0){//余数不为零
			return (totalPage+1);
		}else{
			return totalPage;
		}
	}
}
