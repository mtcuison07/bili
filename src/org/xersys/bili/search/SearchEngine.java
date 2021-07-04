package org.xersys.bili.search;

import org.json.simple.JSONObject;
import org.xersys.bili.search.InvSearchFactory.Type;
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

    public JSONObject Search(Type foFactory, Object foValue) {
        _instance = new InvSearchFactory(_nautilus, _key, _filter, _max, _exact);
        
        switch(foFactory){
            case searchItem:        
                return _instance.searchItem((String) foValue, "sStockIDx»sBarCodex»sDescript");
            case searchItemDisplayOtherInfo:
                return _instance.searchItem((String) foValue, "sStockIDx»sBarCodex»sDescript»sBriefDsc»sAltBarCd»sCategrCd»sBrandCde»sModelCde»sColorCde»sInvTypCd»nUnitPrce»nSelPrce1");
        }
        
        return null;
    }
}
