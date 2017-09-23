package com.codrite.hazelcast.start.configuration;

import com.hazelcast.config.ClasspathXmlConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfiguration {

    private static final String CONFIG = "hazelcast-config.xml";

    @Bean("hazelcastInstance")
    public HazelcastInstance getHazelcastInstance() {
        Hazelcast.newHazelcastInstance(new ClasspathXmlConfig(CONFIG));
        return Hazelcast.newHazelcastInstance(new ClasspathXmlConfig(CONFIG));
    }

}
