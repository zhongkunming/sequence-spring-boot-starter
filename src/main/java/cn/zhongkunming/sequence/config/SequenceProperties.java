package cn.zhongkunming.sequence.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 序列生成器配置
 *
 * @author zhongkunming
 */
@Configuration
@ConfigurationProperties(prefix = SequenceProperties.PREFIX)
@Data
public class SequenceProperties {

    /**
     * 序列生成器类型
     */
    private GeneratorType type;


    public final static String PREFIX = "sequence";
    public final static String TYPE_PREFIX = "sequence.type";
    public final static String UUID = "uuid";
    public final static String REDIS = "redis";

    public final static String ZOOKEEPER = "zookeeper";

    @Getter
    public enum GeneratorType {
        UUID(SequenceProperties.UUID),
        REDIS(SequenceProperties.REDIS),
        ZOOKEEPER(SequenceProperties.ZOOKEEPER),
        ;
        private final String name;

        GeneratorType(String name) {
            this.name = name;
        }
    }

}
