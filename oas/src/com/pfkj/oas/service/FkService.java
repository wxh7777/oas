package com.pfkj.oas.service;

import com.pfkj.oas.manager.FkManager;

public class FkService {

	FkManager manager;
	
	
	public FkManager getManager() {
		return manager;
	}


	public void setManager(FkManager manager) {
		this.manager = manager;
	}

	public void qrsq(String jsdbh, double sqje) {
		manager.qrsq(jsdbh,sqje);
	}


	public String sqsh(String sqid, boolean istg) {
		try{
			manager.sqsh(sqid,istg);
			return "成功";
		}
		catch(Exception e){
			return "失败";
		}
	}



}
