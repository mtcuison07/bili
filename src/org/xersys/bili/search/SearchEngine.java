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
        
        switch(foFactory){
            case searchInvItemSimple:        
                return _instance.searchItem((String) foValue, "sStockIDx»sBarCodex»sDescript");
            case searchInvItemComplex:
                return _instance.searchItem((String) foValue, "sStockIDx»sBarCodex»sDescript»sBriefDsc»sAltBarCd»sCategrCd»sBrandCde»sModelCde»sColorCde»sInvTypCd»nUnitPrce»nSelPrce1");
            case searchInvBranchSimple:
                return _instance.searchBranchInventory((String) foValue, "sStockIDx»sBarCodex»sDescript");
            case searchInvBranchComplex:
                return _instance.searchBranchInventory((String) foValue, "sStockIDx»sBarCodex»sDescript»sBriefDsc»sAltBarCd»sCategrCd»sBrandCde»sModelCde»sColorCde»sInvTypCd»nUnitPrce»nSelPrce1");
                
        }
        
        return null;
    }
}
