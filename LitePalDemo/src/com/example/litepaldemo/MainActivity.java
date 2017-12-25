package com.example.litepaldemo;

import java.util.List;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	
	private String TAG = "TEST";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		LitePalTest();
	}
	
	private void LitePalTest() {
		// 创建表
		SQLiteDatabase db = Connector.getDatabase();
		
		
		//添加数据 save
		for (int i = 0; i< 10; i++) {
			TestData testData = new TestData();
			testData.setType(i);
			testData.setPath("D://TEST");
			testData.setTime("2017110" + String.valueOf(i));
			Log.d(TAG, "id:" + testData.getId());
			boolean isSuccess = testData.save(); //通过save保存，返回值表示是否成功，通过getId获取当前数据的id
			
			Log.d(TAG, "id:" + testData.getId());
			Log.d(TAG, "isSuccess:" + isSuccess);
		}
		
		
		// 修改数据(update:通过id)
		ContentValues values = new ContentValues();
		values.put("path", "文件路径");  
		DataSupport.update(TestData.class, values, 5);
		
		
		// 删除(delete:通过id)
		DataSupport.delete(TestData.class, 2);
		
		
		// 查询一条数据
		TestData testData = DataSupport.find(TestData.class, 1);
		Log.d(TAG, "testData find id:" + testData.getId());
		Log.d(TAG, "testData find time:" + testData.getTime());
		Log.d(TAG, "--------------TestData---------------");
		
		
		// 查询部分id数据
		//List<TestData> testDataList = DataSupport.findAll(TestData.class, 1, 3, 5, 7);
		
		
		// 查询全部数据 findAll
//		List<TestData> testDataList = DataSupport.findAll(TestData.class);
//		for (TestData test : testDataList) {
//			Log.d(TAG, "testData list find id:" + test.getId());
//			Log.d(TAG, "testData list find time:" + test.getTime());
//			Log.d(TAG, "-----------TestData List------------------");
//		}
	}
}
