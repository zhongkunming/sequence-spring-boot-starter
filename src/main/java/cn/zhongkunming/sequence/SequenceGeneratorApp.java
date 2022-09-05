package cn.zhongkunming.sequence;

import cn.zhongkunming.sequence.config.SequenceProperties;
import cn.zhongkunming.sequence.config.ZookeeperProperties;
import cn.zhongkunming.sequence.core.SequenceGenerator;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author zhongkunming
 */
@SpringBootApplication
public class SequenceGeneratorApp implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(SequenceGeneratorApp.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println(applicationContext.getBean(ZookeeperProperties.class));
        System.out.println(applicationContext.getBean(SequenceGenerator.class).generate());
        System.out.println(applicationContext.getBean(SequenceProperties.class).getType().name().toLowerCase());
    }
}
