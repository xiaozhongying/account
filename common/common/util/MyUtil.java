package common.util;

import common.auth.Auth;
public class MyUtil
{
	public static int  getMySspq(Auth auth)
	{
		int sspq=0;//所属片区
		switch(auth.getName())
		{
			case "越秀区商务委":
				sspq=1;
				break;
			case "荔湾区商务委":
				sspq=2;
				break;
			case "海珠区商务委":
				sspq=3;
				break;
			case "天河区商务委":
				sspq=4;
				break;
			case "白云区商务委":
				sspq=5;
				break;
			case "黄埔区商务委":
				sspq=6;
				break;
			case "番禺区商务委":
				sspq=7;
				break;
			case "花都区商务委":
				sspq=8;
				break;
			case "南沙区商务委":
				sspq=9;
				break;
			case "增城区商务委":
				sspq=10;
				break;
			case "从化区商务委":
				sspq=11;
				break;
		}
		return sspq;
	}
}
