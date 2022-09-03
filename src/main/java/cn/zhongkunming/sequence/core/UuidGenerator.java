package cn.zhongkunming.sequence.core;

import java.util.UUID;

/**
 * @author zhongkunming
 */
public class UuidGenerator extends AbstractSequenceGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
