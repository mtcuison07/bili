package org.xersys.bili.dto;

public class Sales_Others{
    String sBarCodex;
    String sDescript;
    String sOtherInf;
    Number nUnitPrce;
    int nQtyOnHnd;
    
    public Sales_Others(){
        sBarCodex = "";
        sDescript = "";
        sOtherInf = "";
        nUnitPrce = 0.00;
        nQtyOnHnd = 0;
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
    
    public void setOtherInfo(String fsValue){
        sOtherInf = fsValue;
    }
    public String getOtherInfo(){
        return sOtherInf;
    }
    
    public void setUnitPrice(Number fnValue){
        nUnitPrce = fnValue;
    }
    public Number getUnitPrice(){
        return nUnitPrce;
    }
    
    public void setQtyOnHand(int fnValue){
        nQtyOnHnd = fnValue;
    }
    public int getQtyOnHand(){
        return nQtyOnHnd;
    }
}
