package bo;

import entity.StoreKeeper;

import java.util.ArrayList;

public class StoreKeeperManager {
    ArrayList<StoreKeeper> listStoreKeepers = new ArrayList<StoreKeeper>();

    public StoreKeeperManager() {
    }

    public StoreKeeper addStoreKeeper(StoreKeeper s) throws Exception {
        if (s == null) throw new Exception("StoreKeeper cannot be null");
        listStoreKeepers.add(s);
        return s;
    }

    public StoreKeeper searchByStoreKeeper(StoreKeeper skk) throws Exception {
        for (StoreKeeper s : listStoreKeepers) {
            if (s.getName().equalsIgnoreCase(skk.getName())) {
                return s;
            }
        }
        throw new Exception("StoreKeeper not found");
    }
}
