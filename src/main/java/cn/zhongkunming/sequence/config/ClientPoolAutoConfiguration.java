package cn.zhongkunming.sequence.config;

import cn.zhongkunming.sequence.core.pool.ClientConnect;
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
@ConditionalOnBean(Pooled.class)
public class ClientPoolAutoConfiguration {

    @Bean
    public GenericObjectPool<ClientConnect> pool(PooledObjectFactory<ClientConnect> factory) {
        GenericObjectPoolConfig<ClientConnect> config = new GenericObjectPoolConfig<>();
        config.setJmxEnabled(false);
        return new GenericObjectPool<>(factory, config);
    }
}
