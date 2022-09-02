package cn.zhongkunming.sequence.config;

import cn.zhongkunming.sequence.core.SequenceGenerator;
import cn.zhongkunming.sequence.core.UuidGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhongkunming
 */
@Configuration
public class SequenceGeneratorAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(SequenceGenerator.class)
    public SequenceGenerator sequenceGenerator(SequenceProperties properties) {
        return new UuidGenerator();
    }

}
