package com.root.entity;

public class DictValue {
    private String id;

    private String dictName;

    private String itemCode;

    private String itemDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }

	public Object getRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	public char[] codeToName(String dictName2, String itemCode2) {
		// TODO Auto-generated method stub
		return null;
	}
}