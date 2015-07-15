package com.pfkj.oas.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.pfkj.oas.file.HtmxResult;
import com.pfkj.oas.file.JcmxResult;
import com.pfkj.oas.file.JcmxResult.JcmxBase;
import com.pfkj.oas.model.HthbDo;
import com.pfkj.oas.recover.model.IncomeContract;
import com.pfkj.oas.recover.service.IncomeContractService;
import com.pfkj.oas.service.JsdService;
import com.pfkj.oas.util.JsonUtil;
import com.pfkj.oas.util.StringUtil;

public class FileAction extends BaseAction {
    private File[] myFile; //上传的文件
    private String[] myFileFileName; //文件名称
    private String[] myFileContentType; //文件类型
    private String savePath;
    
    private File hthbYjFile;
    private String hthbYjFileFileName;
    private String hthbYjFileContentType;
    
    private String dwFileName;
    
    private File htmxFile;
    private String htmxFileFileName;
    private String htmxFileContentType;
    
    private File jcmxFile;
    private String jcmxFileFileName;
    private String jcmxFileContentType;
    
    private JsdService service;
    
    public JsdService getService() {
		return service;
	}

	public void setService(JsdService service) {
		this.service = service;
	}
    
	//收入合同
    private IncomeContractService incomeContractService;
    
    public IncomeContractService getIncomeContractService() {
		return incomeContractService;
	}

	public void setIncomeContractService(IncomeContractService incomeContractService) {
		this.incomeContractService = incomeContractService;
	}
    
	public File getHtmxFile() {
		return htmxFile;
	}

	public void setHtmxFile(File htmxFile) {
		this.htmxFile = htmxFile;
	}

	public File[] getMyFile() {
		return myFile;
	}

	public void setMyFile(File[] myFile) {
		this.myFile = myFile;
	}

	public String[] getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String[] myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String[] getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String[] myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public File getHthbYjFile() {
		return hthbYjFile;
	}

	public void setHthbYjFile(File hthbYjFile) {
		this.hthbYjFile = hthbYjFile;
	}

	public String getHthbYjFileFileName() {
		return hthbYjFileFileName;
	}

	public void setHthbYjFileFileName(String hthbYjFileFileName) {
		this.hthbYjFileFileName = hthbYjFileFileName;
	}

	public String getHthbYjFileContentType() {
		return hthbYjFileContentType;
	}

	public void setHthbYjFileContentType(String hthbYjFileContentType) {
		this.hthbYjFileContentType = hthbYjFileContentType;
	}

	/**
     * 返回上传文件保存的位置
     * 
     * @return
     * @throws Exception
     */
    public String getSavePath() throws Exception {
        return ServletActionContext.getServletContext().getRealPath(savePath);
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
    
    public String getDwFileName() {
		return getDwChineseFileName();
	}

	public void setDwFileName(String dwFileName) {
		this.dwFileName = dwFileName;
	}

	public String getHtmxFileFileName() {
		return htmxFileFileName;
	}

	public void setHtmxFileFileName(String htmxFileFileName) {
		this.htmxFileFileName = htmxFileFileName;
	}

	public String getHtmxFileContentType() {
		return htmxFileContentType;
	}

	public void setHtmxFileContentType(String htmxFileContentType) {
		this.htmxFileContentType = htmxFileContentType;
	}

	public File getJcmxFile() {
		return jcmxFile;
	}

	public void setJcmxFile(File jcmxFile) {
		this.jcmxFile = jcmxFile;
	}

	public String getJcmxFileFileName() {
		return jcmxFileFileName;
	}

	public void setJcmxFileFileName(String jcmxFileFileName) {
		this.jcmxFileFileName = jcmxFileFileName;
	}

	public String getJcmxFileContentType() {
		return jcmxFileContentType;
	}

	public void setJcmxFileContentType(String jcmxFileContentType) {
		this.jcmxFileContentType = jcmxFileContentType;
	}

	public void uploadHthb(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String xmid = request.getParameter("xmid");
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			//取得需要上传的文件数组
	        File[] files = getMyFile();
	        String hbbh = StringUtil.getNanoStrByLength(20);
	        if (files !=null && files.length > 0) {
	        	File file = new File(getSavePath() + "\\" + hbbh);
	        	if  (!file.exists()) {
	        		file.mkdirs();
	        	}
	        	StringBuffer filesStr = new StringBuffer();
				HthbDo hthb = new HthbDo();
				hthb.setHbbh(hbbh);
				hthb.setXmid(xmid);
				hthb.setEnabled(true);
	            for (int i = 0; i < files.length; i++) {
	                //建立上传文件的输出流, getImageFileName()[i]
	                String filename =  "\\" + hbbh + "\\"+ getMyFileFileName()[i] ;
	                System.out.println(getSavePath() +filename);
	                FileOutputStream fos = new FileOutputStream(getSavePath() +filename);
	                //建立上传文件的输入流
	                FileInputStream fis = new FileInputStream(files[i]);
	                byte[] buffer = new byte[1024];
	                int len = 0;
	                while ((len=fis.read(buffer))>0) {
	                    fos.write(buffer, 0, len);
	                }
	                fos.close();
	                fis.close();
	                filesStr.append(filename+";");
	            }
	            
		        hthb.setFiles(filesStr.toString());
		        hthb.setHtFilesDate(new Date());
		        service.saveHthbDo(hthb);
	        }
			pw.print(hbbh);
			pw.flush();
			pw.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void uploadHthbYj(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String hthbbh = request.getParameter("hthbbh");
		String type = request.getParameter("type");
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
			if(principal instanceof UserDetails){  
				String username = ((UserDetails)principal).getUsername();  
				//取得需要上传的文件数组
		        File file = this.getHthbYjFile();
		        HthbDo hthb = service.getHthbDoByHthbbh(hthbbh);
		        if(hthb!=null){
		            //建立上传文件的输出流, getImageFileName()[i]
		            String filename =  "\\" + hthbbh + "\\"+ this.getHthbYjFileFileName() ;
		            System.out.println(getSavePath() +filename);
		            FileOutputStream fos = new FileOutputStream(getSavePath() +filename);
		            //建立上传文件的输入流
		            FileInputStream fis = new FileInputStream(file);
		            byte[] buffer = new byte[1024];
		            int len = 0;
		            while ((len=fis.read(buffer))>0) {
		                fos.write(buffer, 0, len);
		            }
		            fos.close();
		            fis.close();
		            if("A".equals(type)){
			            hthb.setShFileA(filename);
			            hthb.setShFileADate(new Date());
			            hthb.setShrA(username);
		            }
		            else if("B".equals(type)){
			            hthb.setShFileB(filename);
			            hthb.setShFileBDate(new Date());
			            hthb.setShrB(username);
		            }
				    service.saveHthbDo(hthb);
				    
					pw.print( this.getHthbYjFileFileName());
		        }
		        else{
		        	pw.print("error");
		        }
			}
			else{
				pw.print("error");
			}
			pw.flush();
			pw.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public InputStream getDownloadFile() throws Exception  
    {  
    	return new FileInputStream(this.getSavePath() + getDwChineseName());
    }  
    public String download() throws UnsupportedEncodingException{
    	return SUCCESS;
    }
    
 // 如果下载文件名为中文，进行字符编码转换  
    public String getDwChineseFileName() {  
    	String name = getDwChineseName();
    	String dwChineseFileName = name.substring(name.lastIndexOf("\\")+1);
    	try {
			dwChineseFileName = new String(dwChineseFileName.getBytes("utf-8"),"iso8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return dwChineseFileName;  
    } 
    public String getDwChineseName() {  
        String dwChineseFileName = dwFileName;
        try {
			dwChineseFileName = java.net.URLDecoder.decode(dwFileName,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return dwChineseFileName;  
    }
    
    public void uploadHtmxFile(){

		HttpServletResponse response = ServletActionContext.getResponse();
	
				  
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw ;
		String result = "";
        
        	try {
				pw = response.getWriter();
				String extensionName = htmxFileFileName.substring(htmxFileFileName.lastIndexOf(".")+1);
				if(!extensionName.toLowerCase().equals("xls")&&!extensionName.toLowerCase().equals("xlsx")){
					result = "请选择EXCEL格式的文件";
				}
				else{

					HtmxResult htmx = new HtmxResult();
					htmx.generateAllhtmxFile(htmxFile,extensionName);
					result = service.getHtmxFileResult(htmx.getAllHtMx());
				}
				pw.print(result);
				pw.flush();
				pw.close(); 
        	} catch (IOException e1) {
				e1.printStackTrace();
			} 
		
    }
    

    public void uploadJcmxFile(){

		HttpServletResponse response = ServletActionContext.getResponse();
	
				  
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw ;
		String result = "";
        
        	try {
				pw = response.getWriter();
				String extensionName = jcmxFileFileName.substring(jcmxFileFileName.lastIndexOf(".")+1);
				if(!extensionName.toLowerCase().equals("xls")&&!extensionName.toLowerCase().equals("xlsx")){
					result = "请选择EXCEL格式的文件";
				}
				else{
					JcmxResult jcmx = new JcmxResult();
					jcmx.generateAllJcmxFile(jcmxFile,extensionName);
					JcmxBase jcmxBase = jcmx.jBase;
					result = service.getJcmxFileResult(jcmxBase);
				}
				pw.print(result);
				pw.flush();
				pw.close(); 
        	} catch (IOException e1) {
				e1.printStackTrace();
			} 
		
    }
    
    /**
     * 上传收入合同
     */
    public void uploadIncomeContract(){
    	int ret = -1;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			//取得需要上传的文件数组
	        File[] files = getMyFile();
	        String hbbh = StringUtil.getNanoStrByLength(20);
	        if (files !=null && files.length > 0) {
	        	File file = new File(getSavePath() + "\\" + hbbh);
	        	if  (!file.exists()) {
	        		file.mkdirs();
	        	}
	        	
	        	IncomeContract incomeContract = new IncomeContract();
	        	String type = request.getParameter("type");
	    		String number = request.getParameter("number");
	    		String xiangmuId = request.getParameter("xiangmuId");
	    		//获取用户名
	    		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    		String userId = userDetails.getUsername();
	        	incomeContract.setType(type);
	        	incomeContract.setNumber(number);
	        	incomeContract.setXiangmuId(xiangmuId);
	        	incomeContract.setUserId(userId);
	        	incomeContract.setStatus(1);
				
	        	StringBuffer fileStr = new StringBuffer();
	            for (int i = 0; i < files.length; i++) {
	            	if(fileStr.equals("")){
	            		fileStr.append(";");
	            	}
	                //建立上传文件的输出流, getImageFileName()[i]
	                String filename =  "\\" + hbbh + "\\"+ getMyFileFileName()[i] ;
	                System.out.println(getSavePath() +filename);
	                FileOutputStream fos = new FileOutputStream(getSavePath() +filename);
	                //建立上传文件的输入流
	                FileInputStream fis = new FileInputStream(files[i]);
	                byte[] buffer = new byte[1024];
	                int len = 0;
	                while ((len=fis.read(buffer))>0) {
	                    fos.write(buffer, 0, len);
	                }
	                fos.close();
	                fis.close();
	                fileStr.append(filename);
	            }
	            incomeContract.setPath(fileStr.toString());
	            incomeContract.setUploadTime(new Date());
		        boolean res = incomeContractService.insert(incomeContract);
		        if(res){
		        	ret = 1;
		        }
		        JsonUtil.output(response, ""+ret);
	        }
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
}
