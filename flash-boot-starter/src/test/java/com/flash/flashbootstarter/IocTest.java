package com.flash.flashbootstarter;

import com.flash.flashbootstarter.aop.Aop;
import com.flash.flashbootstarter.controller.TestController;
import com.flash.flashbootstarter.core.BeanContainer;
import com.flash.flashbootstarter.ioc.Ioc;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class IocTest {
    @Test
    public void doIoc(){
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.flash.flashbootstarter");
        new Ioc().doIoc();
        new Aop().doAop();
        TestController controller = (TestController) beanContainer.getBean(TestController.class);
        controller.hello();

        controller.helloForAspect();
    }
}
