package cn.zhongkunming.sequence.config;

import cn.zhongkunming.sequence.core.RedisGenerator;
import cn.zhongkunming.sequence.core.SequenceGenerator;
import cn.zhongkunming.sequence.core.UuidGenerator;
import cn.zhongkunming.sequence.core.ZookeeperGenerator;
import cn.zhongkunming.sequence.core.pool.ClientConnect;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhongkunming
 */
@Configuration
public class GeneratorAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(SequenceGenerator.class)
    public SequenceGenerator sequenceGenerator() {
        return new UuidGenerator();
    }

    @Bean
    @ConditionalOnBean(GenericObjectPool.class)
    public SequenceGenerator sequenceGenerator(GenericObjectPool<ClientConnect> pool, SequenceProperties properties) {
        switch (properties.getType()) {
            case REDIS:
                return new RedisGenerator(pool);
            case ZOOKEEPER:
                return new ZookeeperGenerator(pool);
            default:
                throw new RuntimeException("");
        }

    }

}
