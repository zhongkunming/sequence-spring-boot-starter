package cn.zhongkunming.sequence.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhongkunming
 */

@Data
@Configuration
//@ConditionalOnProperty(prefix = SequenceProperties.PREFIX, name = SequenceProperties.TYPE_PREFIX, havingValue = SequenceProperties.REDIS)
//@ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
public class DataSourceProperties {
}
