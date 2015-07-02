package com.pfkj.oas.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class HtmxResult extends readLoadFiles{
	
	private Set<HtmxBase> allHtmx = null;
	
	public HtmxResult(){
	    allHtmx = new HashSet<HtmxBase>();
	}
	
	public Set<HtmxBase> getAllHtMx(){
		return allHtmx;
	}
	
	public void generateAllhtmxPath(String filePath,String extensionName,int sheetNum){
		generateAllhtmxFile(new File(filePath),extensionName,sheetNum);
	}

	public void generateAllhtmxFile(File file,String extensionName){
		generateAllhtmxFile(file,extensionName,0);
	}
	public void generateAllhtmxFile(File file,String extensionName, int sheetNum){
		try {
			List<String> list = HtmxResult.exportListFromExcel(new FileInputStream(file), extensionName, sheetNum);
			if (!list.isEmpty()){
				HtmxBase hBase = null;
				boolean isTitle = true;
				for(String rowList: list){
					System.out.println(rowList);
					if (isTitle){
						isTitle = false;
						continue;
					} else {
						hBase = new HtmxBase();
						String[] htmxDetail = rowList.split("\t");
						hBase.xh = htmxDetail[1].replaceAll("\\.0$", "");
						hBase.htmxZymc = htmxDetail[2].replaceAll("\\.0$", "");
						hBase.htmxGg = htmxDetail[3].replaceAll("\\.0$", "");
						hBase.htmxDw = htmxDetail[4].replaceAll("\\.0$", "");
						hBase.htmxDj = htmxDetail[5].replaceAll("\\.0$", "");
						hBase.htmxSl = htmxDetail[6].replaceAll("\\.0$", "");
						hBase.htmxZj = htmxDetail[7].replaceAll("\\.0$", "");
						System.out.println(hBase.toString());
						allHtmx.add(hBase);
						hBase = null;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public class HtmxBase {
		public String xh;
		public String htmxZymc;
		public String htmxGg;
		public String htmxDw;
		public String htmxDj;
		public String htmxSl;
		public String htmxZj;
		
		public HtmxBase(){
			xh = null;
			htmxZymc = null;
			htmxGg = null;
			htmxDw = null;
			htmxDj = null;
			htmxSl = null;
			htmxZj = null;
		}
		
		public boolean checkIsWrite(){
			return xh!=null && htmxZj != null && htmxZymc != null && htmxGg != null && htmxDw != null && htmxDj != null && htmxSl != null;
		}
		
		public String toString(){
			return "序号:"+xh+";\t资源名称:"+htmxZymc+";\t规格:"+htmxGg+";\t单位:"+htmxDw+";\t单价:"+htmxDj+";\t数量:"+htmxSl+";\t总价:"+htmxZj+";\n";
		}
	}
	
	public static void main(String[] args) {
		String path = "F:/1/insert.tmp";
		HtmxResult htmxResult = new HtmxResult();
		htmxResult.generateAllhtmxPath(path,"xls", 1);
		Set<HtmxBase> baseList = htmxResult.allHtmx;
		for(HtmxBase base:baseList){
			System.out.println(base.htmxDj);
		}
	}

}
