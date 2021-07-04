package org.xersys.bili.dto;

public class PO_Others{
    String sBarCodex;
    String sDescript;
    
    public PO_Others(){
        sBarCodex = "";
        sDescript = "";
    }
    
    public void setBarCode(String fsValue){
        sBarCodex = fsValue;
    }
    public String getBarCode(){
        return sBarCodex;
    }
    
    public void setDescript(String fsValue){
        sDescript = fsValue;
    }
    public String getDescript(){
        return sDescript;
    }
}
