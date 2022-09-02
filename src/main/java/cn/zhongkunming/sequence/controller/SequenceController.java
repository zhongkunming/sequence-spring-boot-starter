package cn.zhongkunming.sequence.controller;

import cn.zhongkunming.sequence.service.SequenceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhongkunming
 */
@RestController
@RequestMapping("/seq")
public class SequenceController {

    @Resource
    SequenceService sequenceService;

    @RequestMapping("/get")
    public String get() {
        return sequenceService.get();
    }
}
