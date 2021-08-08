package com.ribbon.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Andrew Yang
 * @ClassName MySelfRule
 * @Description
 * @Package com.ribbon.rule
 * @Create 2021-08-05 14:25
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        return new RoundRobinRule();
    }
}
