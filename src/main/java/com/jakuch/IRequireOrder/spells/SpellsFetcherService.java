package com.jakuch.IRequireOrder.spells;

import com.jakuch.IRequireOrder.SrdFetcherServiceBase;
import org.json.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpellsFetcherService extends SrdFetcherServiceBase {

    @Override
    protected String getBaseUrl() {
        return "https://api.open5e.com/v2/spells/";
    }

    @Override
    @Cacheable("spells")
    public List<JSONObject> fetchAllData() {
        return super.fetchAllData();
    }
}
