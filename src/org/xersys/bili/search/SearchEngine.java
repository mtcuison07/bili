package org.xersys.bili.search;

import org.xersys.kumander.contants.SearchEnum;
import org.json.simple.JSONObject;
import org.xersys.kumander.iface.XNautilus;

public class SearchEngine implements XSearch{
    private final int DEFAULT_LIMIT = 50;
    
    private XNautilus _nautilus;
    
    private String _key;
    private String _filter;
    private int _max;
    private boolean _exact;
    
    private InvSearchFactory _instance;
    
    public SearchEngine(XNautilus foValue){
        _nautilus = foValue;
        
        _key = "";
        _filter = "";
        _max = DEFAULT_LIMIT;
        _exact = false;
    }
    
    @Override
    public void setKey(String fsValue) {
        _key = fsValue;
    }

    @Override
    public void setFilter(String fsValue) {
        _filter = fsValue;
    }

    @Override
    public void sethMax(int fnValue) {
        _max = fnValue;
    }

    @Override
    public void setExact(boolean fbValue) {
        _exact = fbValue;
    }

    public JSONObject Search(SearchEnum.Type foFactory, Object foValue) {
        _instance = new InvSearchFactory(_nautilus, _key, _filter, _max, _exact);
        
        JSONObject loJSON = null;
        String lsColName;
        
        switch(foFactory){
            case searchInvItemSimple:      
                lsColName = "sBarCodex»sDescript»sStockIDx";
                loJSON = _instance.searchItem((String) foValue, lsColName);
                if ("success".equals((String) loJSON.get("result"))) {
                    loJSON.put("headers", "Part Number»Description»ID");
                    loJSON.put("colname", lsColName);
                }
                break;
            case searchInvItemComplex:
                lsColName = "sBarCodex»sDescript»sCategrCd»sBrandCde»sModelCde»sColorCde»sInvTypCd»nUnitPrce»nSelPrce1»sStockIDx";
                loJSON = _instance.searchItem((String) foValue, lsColName);
                if ("success".equals((String) loJSON.get("result"))) {
                    loJSON.put("headers", "Part Number»Description»Category»Brand»Model»Color»Inv. Type»Inv. Price»SRP»ID");
                    loJSON.put("colname", lsColName);
                }
                break;
            case searchInvBranchSimple:
                lsColName = "sBarCodex»sDescript»sStockIDx";
                loJSON = _instance.searchBranchInventory((String) foValue, lsColName);
                if ("success".equals((String) loJSON.get("result"))) {
                    loJSON.put("headers", "Part Number»Description»ID");
                    loJSON.put("colname", lsColName);
                }
                break;
            case searchInvBranchComplex:
                lsColName = "sBarCodex»sDescript»sCategrCd»sBrandCde»sModelCde»sColorCde»sInvTypCd»nUnitPrce»nSelPrce1»sStockIDx";
                loJSON = _instance.searchBranchInventory((String) foValue, lsColName);
                if ("success".equals((String) loJSON.get("result"))) {
                    loJSON.put("headers", "Part Number»Description»Category»Brand»Model»Color»Inv. Type»Inv. Price»SRP»ID");
                    loJSON.put("colname", lsColName);
                }
                break;
        }
        
        return loJSON;
    }
}
