package com.cmcc.locationaddress_gps_sdk_test;
import com.cmcc.location_gps_sdk.ILocationDetail;
import com.cmcc.location_gps_sdk.ILocationManger;
import com.cmcc.location_gps_sdk.IReferenceAddress;
import com.cmcc.location_gps_sdk.SDKManager;
import com.example.locationaddress_gps_sdk_test.R;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;

public class MainActivity extends Activity {

	private ILocationManger iLtionMInstance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		iLtionMInstance = SDKManager.getILocationMangerInstance(getApplicationContext());
		iLtionMInstance.getCurrentLocation(iLocatDE);
		setContentView(R.layout.activity_main);
		
		testLocationAddress();
		
	}

		
	
       //拿到定位的城市
		ILocationDetail iLocatDE = new ILocationDetail() {
			public void getLocationDetial(String city) {
				
				Log.i("tag", "定位的城市"+city);
			}
		};
	
		
		//传递至转化成经纬度
		private void testLocationAddress() {
			
			//循环地址
			for(int i=0;i<strArray.length;i++)
		    { 
			 String addressName = strArray[i];
		     Log.i("tag", "地址"+addressName);
			  iLtionMInstance.setDisList(addressName);
			
		      }
			
			iLtionMInstance.getLocationByAdrdress(referCB);
				
			
		}
	

		
		//根据地址转换经纬度算出距离
		IReferenceAddress referCB = new IReferenceAddress() {
			
			@Override
			public void getIReferenceAddress(double distance) {
				
			  Log.i("distance","距离-->"+distance);
				
			}
		};
		
		
		
	 String[] strArray={"北京市西城区宣武门西大2号","北京市西城区宣武门西大街28号","北京市朝阳区慧忠北里309-6号第５大道精品休闲购物广场B2层", "北京市海淀区北安河路68号",
		   "北京市昌平区回龙观北店嘉园26号","北京市大兴区北程庄金星路"," 北京市大兴区天宝园五里一区22号","北京市海淀区西三旗桥东","北京市朝阳区安定路甲3号"," 北京市海淀区上地十街10号",
		   "北京市朝阳区慧忠北里309-6号第５大道精品休闲购物广场B2层","北京市海淀区怡美家园","北京市海淀区交通大学路","北京市海淀区交通大学路1号院","北京市丰台区北京西站南路168号513室",
		   "朝阳区崔各庄乡大望京村"," 昌平科技园区星火街9号","北京市昌平区立汤路186号龙德广场五层","昌平区兴寿镇东营村上东路和上西路交叉口"," 北京市朝阳区将台乡尚君庙28号","北京市昌平区南口镇马坊村",
		   "北京市昌平区于新庄路","北京市昌平区北七家镇政府街东","北京市西城区真武庙二条5号","北京西城区永安路175号"," 西城区真武庙二条5号","北京市西城区复兴门外大街19号楼"};
		
		
}
