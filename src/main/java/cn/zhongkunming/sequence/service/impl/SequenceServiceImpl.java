package cn.zhongkunming.sequence.service.impl;

import cn.zhongkunming.sequence.core.SequenceGenerator;
import cn.zhongkunming.sequence.service.SequenceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhongkunming
 */
@Service
public class SequenceServiceImpl implements SequenceService {

    @Resource
    private SequenceGenerator sequenceGenerator;

    @Override
    public String get() {
        return sequenceGenerator.generate();
    }
}
