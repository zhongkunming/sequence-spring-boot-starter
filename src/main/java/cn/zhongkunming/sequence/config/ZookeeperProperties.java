package cn.zhongkunming.sequence.config;

import cn.zhongkunming.sequence.core.pool.Pooled;
import lombok.Data;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 配置
 *
 * @author zhongkunming
 */
@Data
@Configuration
@ConditionalOnProperty(prefix = SequenceProperties.PREFIX, name = SequenceProperties.TYPE_PREFIX, havingValue = SequenceProperties.ZOOKEEPER)
@ConfigurationProperties(prefix = ZookeeperProperties.PREFIX)
public class ZookeeperProperties implements Pooled {

    private String url = "127.0.0.1:2181";

    public final static String PREFIX = "sequence.zookeeper";

    public CuratorFramework build() {
        return CuratorFrameworkFactory.newClient(url, new RetryNTimes(10, 5000));
    }


}
