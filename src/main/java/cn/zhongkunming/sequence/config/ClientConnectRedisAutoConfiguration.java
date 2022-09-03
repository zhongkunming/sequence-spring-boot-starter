package cn.zhongkunming.sequence.config;

import cn.zhongkunming.sequence.core.pool.ClientConnect;
import cn.zhongkunming.sequence.core.pool.ClientConnectRedis;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhongkunming
 */
@Configuration
@ConditionalOnBean(RedisProperties.class)
public class ClientConnectRedisAutoConfiguration {

    @Bean
    public ClientConnect connect(RedisProperties properties){
        return new ClientConnectRedis(properties.build());
    }
}
