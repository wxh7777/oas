package com.pfkj.oas.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class JcmxResult  extends readLoadFiles{
	public JcmxBase jBase = null;
	
	public JcmxResult(){
		jBase = new JcmxBase();
	}
	public void generateAllJcmxPath(String filePath,String extensionName,int sheetNum){
		generateAllJcmxFile(new File(filePath),extensionName,sheetNum);
	}

	public void generateAllJcmxFile(File file,String extensionName){
		generateAllJcmxFile(file,extensionName,0);
	}
	public void generateAllJcmxFile(File file,String extensionName, int sheetNum){
		try {
			List<String> list = JcmxResult.exportListFromExcel(new FileInputStream(file), extensionName, sheetNum);
			if (!list.isEmpty()){
				boolean isTitle = true;
				boolean isDetail = false;
				int zs = 0;
				for(String rowList: list){
					//System.out.println(rowList);
					String [] rowDetail = rowList.split("\t");
					if (isTitle){
						isTitle = false;
						continue;
					} else {
						if (isDetail){
							JcmxDetail jDetail = new JcmxDetail();
							if(rowDetail.length==5){
								jDetail.jcmxXh = rowDetail[1].replaceAll("\\.0$", "");
								jDetail.jcmxPh = rowDetail[2].replaceAll("\\.0$", "");
								jDetail.jcmxSl = rowDetail[4].replaceAll("\\.0$", "");
								zs += (int)Double.parseDouble(jDetail.jcmxSl);
								jBase.jcmxDetail.add(jDetail);
							}
						} else {
							if("结算单位：".equals(rowDetail[1])){
								jBase.jcmxJsdw = rowDetail[3].replaceAll("\\.0$", "");
							}
							else if("结算项目：".equals(rowDetail[1])){
								jBase.jcmxJsxm = rowDetail[3].replaceAll("\\.0$", "");
							}
							else if("规格：".equals(rowDetail[1])){
								jBase.jcmxGg = rowDetail[3].replaceAll("\\.0$", "");
							}
							else if("供货日期：".equals(rowDetail[1])){
								jBase.jcmxGhrq = rowDetail[3].replaceAll("\\.0$", "");
							}
							else if("序号".equals(rowDetail[1])){
								isDetail = true;
							}

						}

					}
					jBase.jcmxZs = String.valueOf(zs);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public class JcmxDetail{
		public String jcmxXh;
		public String jcmxPh;
		public String jcmxSl;
		
		public JcmxDetail(){
			jcmxXh = null;
			jcmxPh = null;
			jcmxSl = null;
		}
		
		public JcmxDetail(String jcmxXh){
			this.jcmxXh = jcmxXh;
			jcmxPh = null;
			jcmxSl = null;
		}
		
		public JcmxDetail(String jcmxXh,String jcmxPh){
			this.jcmxXh = jcmxXh;
			this.jcmxPh = jcmxPh;
			jcmxSl = null;
		}
		
		public JcmxDetail(String jcmxXh,String jcmxPh,String jcmxSl){
			this.jcmxXh = jcmxXh;
			this.jcmxPh = jcmxPh;
			this.jcmxSl = jcmxSl;
		}
	}
	
	public class JcmxBase {
		public String jcmxJsdw;
		public String jcmxJsxm;
		public String jcmxGg;
		public String jcmxGhrq;
		public String jcmxZs;
		public Set<JcmxDetail> jcmxDetail;
		
		public JcmxBase(){
			jcmxJsdw = null;
			jcmxJsxm = null;
			jcmxGg = null;
			jcmxGhrq = null;
			jcmxZs = null;
			jcmxDetail = new HashSet<JcmxDetail>();
		}
		
		public boolean checkIsWrite(){
			return  jcmxJsdw != null && jcmxJsxm != null && jcmxGg != null && jcmxGhrq != null && jcmxZs!=null && jcmxDetail.size() != 0;
		}
		
	}
	
	public static void main(String[] args) {
		String path = "F:/1/进场材料明细.xls";
		JcmxResult jcmxResult = new JcmxResult();
		jcmxResult.generateAllJcmxPath(path, "xls",0);
		JcmxBase base = jcmxResult.jBase;
		System.out.println(base.toString());
		
	}
}
