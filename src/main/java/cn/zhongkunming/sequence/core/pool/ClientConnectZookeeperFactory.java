package cn.zhongkunming.sequence.core.pool;

import cn.zhongkunming.sequence.config.ZookeeperProperties;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * @author zhongkunming
 */
public class ClientConnectZookeeperFactory implements PooledObjectFactory<ClientConnect> {

    private final ZookeeperProperties properties;

    public ClientConnectZookeeperFactory(ZookeeperProperties properties) {
        this.properties = properties;
    }

    @Override
    public void activateObject(PooledObject<ClientConnect> p) throws Exception {

    }

    @Override
    public void destroyObject(PooledObject<ClientConnect> p) throws Exception {

    }

    @Override
    public PooledObject<ClientConnect> makeObject() throws Exception {
        return new DefaultPooledObject<>(new ClientConnectZookeeper(properties.build()));
    }

    @Override
    public void passivateObject(PooledObject<ClientConnect> p) throws Exception {

    }

    @Override
    public boolean validateObject(PooledObject<ClientConnect> p) {
        return false;
    }
}
