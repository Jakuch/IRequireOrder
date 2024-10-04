package com.jakuch.IRequireOrder.srd.characterClass.service;

import com.jakuch.IRequireOrder.srd.characterClass.model.CharacterClass;
import com.jakuch.IRequireOrder.srd.SrdFetcherServiceBase;
import org.json.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterClassFetcherService extends SrdFetcherServiceBase {
    @Override
    protected String getBaseUrl() {
        return "https://api.open5e.com/v2/classes/";
    }

    @Override
    @Cacheable("classes")
    public List<JSONObject> fetchAllData() {
        return super.fetchAllData();
    }

    @Cacheable("mappedClasses")
    public List<CharacterClass> fetchMappedCharacterClassList() {
        return fetchAllData().stream().filter(jsonObject -> jsonObject.isNull("subclass_of")).map(jsonObject -> new CharacterClass(jsonObject.getString("name"), jsonObject.getString("key"))).collect(Collectors.toList());
    }

    public CharacterClass fetchMappedCharacterClass(String srdKey) {
        var jsonObject = fetchSingleRecordByKey(srdKey);
        return new CharacterClass(jsonObject.getString("name"), jsonObject.getString("key"));
    }
}
