package com.root.entity;

public class ConfigInfo {
    private Integer id;

    private String channelid;

    private String wfwuaturl;

    private String wfwcmisurl;

    private String oldurl;

    private String publickey;

    private String privatekey;

    private String uatsupercode;

    private String uatcoopercode;

    private String cmissupercode;

    private String cmiscoopercode;

    private String filepath;

    private String wfwsiturl;

    private String sitsupercode;

    private String sitcoopercode;

    private String sitloantyp;

    private String uatloantyp;

    private String cmisloantyp;

    private String descinfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid == null ? null : channelid.trim();
    }

    public String getWfwuaturl() {
        return wfwuaturl;
    }

    public void setWfwuaturl(String wfwuaturl) {
        this.wfwuaturl = wfwuaturl == null ? null : wfwuaturl.trim();
    }

    public String getWfwcmisurl() {
        return wfwcmisurl;
    }

    public void setWfwcmisurl(String wfwcmisurl) {
        this.wfwcmisurl = wfwcmisurl == null ? null : wfwcmisurl.trim();
    }

    public String getOldurl() {
        return oldurl;
    }

    public void setOldurl(String oldurl) {
        this.oldurl = oldurl == null ? null : oldurl.trim();
    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey == null ? null : publickey.trim();
    }

    public String getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey == null ? null : privatekey.trim();
    }

    public String getUatsupercode() {
        return uatsupercode;
    }

    public void setUatsupercode(String uatsupercode) {
        this.uatsupercode = uatsupercode == null ? null : uatsupercode.trim();
    }

    public String getUatcoopercode() {
        return uatcoopercode;
    }

    public void setUatcoopercode(String uatcoopercode) {
        this.uatcoopercode = uatcoopercode == null ? null : uatcoopercode.trim();
    }

    public String getCmissupercode() {
        return cmissupercode;
    }

    public void setCmissupercode(String cmissupercode) {
        this.cmissupercode = cmissupercode == null ? null : cmissupercode.trim();
    }

    public String getCmiscoopercode() {
        return cmiscoopercode;
    }

    public void setCmiscoopercode(String cmiscoopercode) {
        this.cmiscoopercode = cmiscoopercode == null ? null : cmiscoopercode.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public String getWfwsiturl() {
        return wfwsiturl;
    }

    public void setWfwsiturl(String wfwsiturl) {
        this.wfwsiturl = wfwsiturl == null ? null : wfwsiturl.trim();
    }

    public String getSitsupercode() {
        return sitsupercode;
    }

    public void setSitsupercode(String sitsupercode) {
        this.sitsupercode = sitsupercode == null ? null : sitsupercode.trim();
    }

    public String getSitcoopercode() {
        return sitcoopercode;
    }

    public void setSitcoopercode(String sitcoopercode) {
        this.sitcoopercode = sitcoopercode == null ? null : sitcoopercode.trim();
    }

    public String getSitloantyp() {
        return sitloantyp;
    }

    public void setSitloantyp(String sitloantyp) {
        this.sitloantyp = sitloantyp == null ? null : sitloantyp.trim();
    }

    public String getUatloantyp() {
        return uatloantyp;
    }

    public void setUatloantyp(String uatloantyp) {
        this.uatloantyp = uatloantyp == null ? null : uatloantyp.trim();
    }

    public String getCmisloantyp() {
        return cmisloantyp;
    }

    public void setCmisloantyp(String cmisloantyp) {
        this.cmisloantyp = cmisloantyp == null ? null : cmisloantyp.trim();
    }

    public String getDescinfo() {
        return descinfo;
    }

    public void setDescinfo(String descinfo) {
        this.descinfo = descinfo == null ? null : descinfo.trim();
    }

	@Override
	public String toString() {
		String str= "ConfigInfo [id=" + id + ", channelid=" + channelid + ", wfwuaturl=" + wfwuaturl + ", wfwcmisurl="
				+ wfwcmisurl + ", oldurl=" + oldurl + ", publickey=" + publickey + ", privatekey=" + privatekey
				+ ", uatsupercode=" + uatsupercode + ", uatcoopercode=" + uatcoopercode + ", cmissupercode="
				+ cmissupercode + ", cmiscoopercode=" + cmiscoopercode + ", filepath=" + filepath + ", wfwsiturl="
				+ wfwsiturl + ", sitsupercode=" + sitsupercode + ", sitcoopercode=" + sitcoopercode + ", sitloantyp="
				+ sitloantyp + ", uatloantyp=" + uatloantyp + ", cmisloantyp=" + cmisloantyp + ", descinfo=" + descinfo
				+ "]";
		System.out.println(str);		
		return str;
	}
    
    
}