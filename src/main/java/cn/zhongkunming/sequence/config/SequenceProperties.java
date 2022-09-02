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
@ConfigurationProperties(prefix = SequenceProperties.SEQUENCE_PREFIX)
@Data
public class SequenceProperties {

    /**
     * 序列生成器类型
     */
    private GeneratorType type;


    protected final static String SEQUENCE_PREFIX = "sequence";
    public final static String UUID = "uuid";

    public final static String REDIS = "redis";

    @Getter
    public enum GeneratorType {
        UUID(SequenceProperties.UUID),
        REDIS(SequenceProperties.REDIS),
        ;
        private final String name;

        GeneratorType(String name) {
            this.name = name;
        }
    }

}