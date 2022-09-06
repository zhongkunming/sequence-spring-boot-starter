package cn.zhongkunming.sequence.config;

import cn.zhongkunming.sequence.core.pool.ClientConnect;
import cn.zhongkunming.sequence.core.pool.ClientConnectRedisFactory;
import cn.zhongkunming.sequence.core.pool.ClientConnectZookeeperFactory;
import cn.zhongkunming.sequence.core.pool.Pooled;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhongkunming
 */
@Configuration
// todo 池化标识
@ConditionalOnBean(Pooled.class)
public class ClientPoolAutoConfiguration {
    @Bean
    public GenericObjectPool<ClientConnect> pool(PooledObjectFactory<ClientConnect> factory) {
        GenericObjectPoolConfig<ClientConnect> config = new GenericObjectPoolConfig<>();
        config.setJmxEnabled(false);
        return new GenericObjectPool<>(factory, config);
    }

    static class Redis {
        @Bean
        @ConditionalOnBean(RedisProperties.class)
        public PooledObjectFactory<ClientConnect> factory(RedisProperties properties) {
            return new ClientConnectRedisFactory(properties);
        }
    }

    static class Zookeeper {
        @Bean
        @ConditionalOnBean(ZookeeperProperties.class)
        public PooledObjectFactory<ClientConnect> factory(ZookeeperProperties properties) {
            return new ClientConnectZookeeperFactory(properties);
        }
    }
}
