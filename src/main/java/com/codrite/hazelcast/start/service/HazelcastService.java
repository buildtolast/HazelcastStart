package com.codrite.hazelcast.start.service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HazelcastService {

    private final HazelcastInstance hazelcastInstance;

    @Autowired
    public HazelcastService(@Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    public <T, S> IMap<T, S> getOrCreateMap(final String mapName){
        return hazelcastInstance.getMap(mapName);
    }

}
