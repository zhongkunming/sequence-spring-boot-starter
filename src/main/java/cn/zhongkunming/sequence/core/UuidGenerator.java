package cn.zhongkunming.sequence.core;

import java.util.UUID;

/**
 * @author zhongkunming
 */
public class UuidGenerator extends AbstractSequenceGenerator {
    @Override
    public String generate() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }
}
