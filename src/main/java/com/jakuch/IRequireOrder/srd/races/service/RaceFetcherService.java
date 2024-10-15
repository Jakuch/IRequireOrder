package com.jakuch.IRequireOrder.srd.races.service;

import com.jakuch.IRequireOrder.srd.SrdFetcherServiceBase;
import com.jakuch.IRequireOrder.srd.races.model.Race;
import org.json.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RaceFetcherService extends SrdFetcherServiceBase<Race> {
    @Override
    protected String getBaseUrl() {
        return "https://api.open5e.com/v2/races/";
    }

    @Override
    @Cacheable("races")
    public List<Race> fetchAllMappedData() {
        return fetchAllData().stream().map(jsonObject -> new Race(jsonObject.getString("name"), jsonObject.getString("key"))).collect(Collectors.toList());
    }

    @Override
    public Race fetchMappedSingleRecord(String srdKey) {
        var jsonObject = fetchSingleRecordByKey(srdKey);
        return new Race(jsonObject.getString("name"), jsonObject.getString("key"));
    }
}
