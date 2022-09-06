package cn.zhongkunming.sequence.core;

import cn.zhongkunming.sequence.core.pool.ClientConnect;
import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 * @author zhongkunming
 */
public class RedisGenerator extends AbstractSequenceGenerator {

    private final GenericObjectPool<ClientConnect> pool;

    public RedisGenerator(GenericObjectPool<ClientConnect> pool) {
        this.pool = pool;
    }

    @Override
    public String generate() {
        ClientConnect connect = null;
        try {
            connect = pool.borrowObject();
            System.out.println(connect);
            return connect.getValue("testKey");
        } catch (Exception e) {
            pool.returnObject(connect);
            throw new RuntimeException(e);
        }
    }
}
