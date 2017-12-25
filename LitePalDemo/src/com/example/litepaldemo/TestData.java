package com.example.litepaldemo;

import org.litepal.crud.DataSupport;

public class TestData extends DataSupport{
	private int id;
	private int type;
	private String time;
	private String path;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public int getId() {
		return id;
	}
	
	public int getType() {
		return type;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getPath() {
		return path;
	}
}
