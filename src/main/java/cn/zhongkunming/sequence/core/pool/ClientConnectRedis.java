package cn.zhongkunming.sequence.core.pool;

import io.lettuce.core.api.StatefulRedisConnection;

/**
 * @author zhongkunming
 */

public class ClientConnectRedis implements ClientConnect {

    private final StatefulRedisConnection<String, String> connect;

    public ClientConnectRedis(StatefulRedisConnection<String, String> connect) {
        this.connect = connect;
    }

    @Override
    public String getValue(String key) {
        return String.valueOf(connect.sync().incr(key));
    }
}
