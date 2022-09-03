package cn.zhongkunming.sequence.core;

import cn.zhongkunming.sequence.core.pool.ClientConnect;
import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 * @author zhongkunming
 */
public class ZookeeperGenerator implements SequenceGenerator {

    private final GenericObjectPool<ClientConnect> pool;

    public ZookeeperGenerator(GenericObjectPool<ClientConnect> pool) {
        this.pool = pool;
    }
    @Override
    public String generate() {
        try {
            return pool.borrowObject().getValue("test");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
