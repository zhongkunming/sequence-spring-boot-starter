package cn.zhongkunming.sequence.core.pool;

import com.google.common.collect.Maps;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicLong;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.Map;
import java.util.Objects;

/**
 * @author zhongkunming
 */
public class ClientConnectZookeeper implements ClientConnect {

    private final CuratorFramework client;

    private final static Map<String, DistributedAtomicLong> map;

    static {
        map = Maps.newConcurrentMap();
    }

    public ClientConnectZookeeper(CuratorFramework client) {
        this.client = client;
        client.start();
    }

    @Override
    public String getValue(String key) {
        DistributedAtomicLong aLong = map.get(key);
        if (Objects.isNull(aLong)) {
            aLong = new DistributedAtomicLong(client, "/" + key, new ExponentialBackoffRetry(500, 3));
            map.put(key, aLong);
        }

        try {
            return String.valueOf(aLong.increment().postValue());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
