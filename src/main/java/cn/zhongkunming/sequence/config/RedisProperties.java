package cn.zhongkunming.sequence.config;

import cn.zhongkunming.sequence.core.pool.Pooled;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Redis配置
 *
 * @author zhongkunming
 */
@Data
@Configuration
@ConditionalOnProperty(prefix = SequenceProperties.PREFIX, name = SequenceProperties.TYPE_PREFIX, havingValue = SequenceProperties.REDIS)
@ConfigurationProperties(prefix = RedisProperties.PREFIX)
public class RedisProperties implements Pooled {

    private String url;

    private String host = "127.0.0.1";

    private int port = 6379;

    private String username;

    private String password;

    private int database = 0;

    public final static String PREFIX = "sequence.redis";

    public StatefulRedisConnection<String, String> build() {
        return RedisClient.create("redis://" + host).connect();
    }



}
