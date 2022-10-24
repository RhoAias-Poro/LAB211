package bo;

import entity.StoreKeeper;

import java.util.ArrayList;

public class StoreKeeperManager {
    ArrayList<StoreKeeper> listStoreKeepers;

    public StoreKeeperManager() {
        listStoreKeepers = new ArrayList<StoreKeeper>();
    }

    public StoreKeeper addStoreKeeper(StoreKeeper s) throws Exception {
        if (s == null) throw new Exception("StoreKeeper cannot be null");
        if (ensureStoreKeeperExist(s)) {
            throw new Exception("Duplicate storekepper information");
        }
        listStoreKeepers.add(s);
        return s;
    }

    public StoreKeeper getStoreKeeperByName(String skk) throws Exception {
        for (StoreKeeper s : listStoreKeepers) {
            if (s.getName().equalsIgnoreCase(skk)) {
                return s;
            }
        }
        throw new Exception("StoreKeeper not found");
    }

    public boolean ensureStoreKeeperExist(StoreKeeper storeKeeper) throws Exception {
        if (storeKeeper == null) throw new Exception("StoreKeeper cannot be null");
        try {
            getStoreKeeperByName(storeKeeper.getName());
            return true;
        } catch (Exception e) {
            addStoreKeeper(storeKeeper);
            return false;
        }
    }
}
