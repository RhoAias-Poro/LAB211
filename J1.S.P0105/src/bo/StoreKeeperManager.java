package bo;

import entity.StoreKeeper;

import java.util.ArrayList;

public class StoreKeeperManager {
    ArrayList<StoreKeeper> listStoreKeepers = new ArrayList<StoreKeeper>();

    public StoreKeeperManager() {}

    public StoreKeeper addStoreKeeper(StoreKeeper s){
        listStoreKeepers.add(s);
        return s;
    }

    public StoreKeeper searchByStoreKeeper(StoreKeeper skk) throws Exception {
        for(StoreKeeper s : listStoreKeepers){
            if(s.getName().toLowerCase().contains(skk.getName())){
                return s;
            }
        }
        throw new Exception("StoreKeeper not found");
    }
}
