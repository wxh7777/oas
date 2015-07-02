package com.pfkj.oas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "GLXT_JSD")
//管理系统_结算单
public class JieSuanDanVo {


	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;

	//结算单编号
	@Column(name = "JSDBH", unique = true, nullable=false)
	private String jsdbh;

	//项目名称
	@Column(name = "XM_ID")
	private String xmid;

	//项目名称
	@Column(name = "XMMC")
	private String xmmc;
	
	@Column(name = "HTBH", nullable=false)
	private String htbh; 
	
	
	//类别
	@Column(name = "LB")
	private String leibie;
	
	//日期
	@Column(name = "RQ",length=8)
	private Date rq;
	
	//填报人
	@Column(name = "TBR")
	private String TBR;
	//总金额
	@Column(name = "ZJE")
	private double zje;
	
	//处理状态
	@Column(name = "CLZT")
	private String clzt;
	
	//填报时间
	@Column(name = "TBSJ")
	private Date tbsj;
	
	//交接时间
	@Column(name = "JJSJ")
	private Date jjsj;
	
	//审核时间
	@Column(name = "SHSJ")
	private Date shsj;
	
	//审核说明
	@Column(name = "SHSM")
	private String shsm;
	
	//打印次数
	@Column(name = "DYCS")
	private int dycs;
	
	//是否预授权标志（预授权表示此结算单是预授权付款时生成的）
	@Column(name = "YSQBZ")
	private char ysqbz;
	
	//多个授权记录
	//@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	//private Set<ShouQuanDo> sqdoSet;
	
	//多个付款通知单
	//@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	//private Set<FktzdVo> fktzdSet;
	@Column(name = "ISENABLED", nullable=false)
	private boolean isEnabled;

	public JieSuanDanVo() {
		super();
		this.isEnabled = true;
		this.clzt = "00";
		this.tbsj = new Date();
		this.dycs = 0;
	}
	
	
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJsdbh() {
		return jsdbh;
	}

	public void setJsdbh(String jsdbh) {
		this.jsdbh = jsdbh;
	}

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}




	public String getHtbh() {
		return htbh;
	}





	public void setHtbh(String htbh) {
		this.htbh = htbh;
	}





	public String getLeibie() {
		return leibie;
	}

	public void setLeibie(String leibie) {
		this.leibie = leibie;
	}

	public Date getRq() {
		return rq;
	}

	public void setRq(Date rq) {
		this.rq = rq;
	}

	public String getTBR() {
		return TBR;
	}

	public void setTBR(String tBR) {
		TBR = tBR;
	}

	

	public boolean isEnabled() {
		return isEnabled;
	}





	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}





	public double getZje() {
		return zje;
	}

	public void setZje(double zje) {
		this.zje = zje;
	}

	public String getClzt() {
		return clzt;
	}

	public void setClzt(String clzt) {
		this.clzt = clzt;
	}

	public Date getJjsj() {
		return jjsj;
	}

	public void setJjsj(Date jjsj) {
		this.jjsj = jjsj;
	}

	public Date getShsj() {
		return shsj;
	}

	public void setShsj(Date shsj) {
		this.shsj = shsj;
	}

	public Date getTbsj() {
		return tbsj;
	}

	public void setTbsj(Date tbsj) {
		this.tbsj = tbsj;
	}

	public String getShsm() {
		return shsm;
	}

	public void setShsm(String shsm) {
		this.shsm = shsm;
	}

	public char getYsqbz() {
		return ysqbz;
	}

	public void setYsqbz(char ysqbz) {
		this.ysqbz = ysqbz;
	}
	
	public int getDycs() {
		return dycs;
	}

	public void setDycs(int dycs) {
		this.dycs = dycs;
	}
	
	
	/*public void generateZje(){
		Iterator<JsdMxVo> jsd=jsdmxSet.iterator();
		while(jsd.hasNext()){
			JsdMxVo jsdVo = (JsdMxVo)jsd.next();
			Set<HeTongMxVo> htmxSet = this.getHetongVo().getHetongMxSet();
			Iterator<HeTongMxVo> htmxs=htmxSet.iterator();
			while(htmxs.hasNext()){
				HeTongMxVo htmx = htmxs.next();
				double je = 0 ;
				if(jsdVo.getZydm()==htmx.getZydm()&&jsdVo.getGg()==htmx.getGuige()){
					double dj = htmx.getDanjia();
					int sl = jsdVo.getSl();
					je = dj*sl;
					break;
				}
				zje += je;
			}
			
		}
		this.setZje(zje);
	}*/
}

