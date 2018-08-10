package com.flash.flashbootstarter.ioc;

import com.flash.flashbootstarter.core.BeanContainer;
import com.flash.flashbootstarter.ioc.Autowired.Autowired;
import com.flash.flashbootstarter.util.ClassUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Optional;

/**
 * 控制反转，依赖注入，容器管理bean的生命周期
 */
@Slf4j
public class Ioc {

    /**
     * Bean容器
     */
    private BeanContainer beanContainer;

    public Ioc() {
        beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行Ioc
     */
    public void doIoc() {
        for (Class<?> clz : beanContainer.getClasses()) {
            final Object targetBean = beanContainer.getBean(clz);
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                //判断属性是否注解注入
                if (field.isAnnotationPresent(Autowired.class)) {
                    final Class<?> fieldClass = field.getType();
                    Object fieldValue = getClassInstance(fieldClass);
                    if (null != fieldValue) {
                        ClassUtil.setField(field, targetBean, fieldValue);
                    } else {
                        throw new RuntimeException("无法注入对应的类，目标类型:" + fieldClass.getName());
                    }
                }
            }
        }
    }

    /**
     * 根据Class获取其实例或者实现类
     *
     * @param clz Class
     * @return 实例或者实现类
     */
    private Object getClassInstance(final Class<?> clz) {
        return Optional
                .ofNullable(beanContainer.getBean(clz))
                .orElseGet(() -> {
                    Class<?> implementClass = getImplementClass(clz);
                    if (null != implementClass) {
                        return beanContainer.getBean(implementClass);
                    }
                    return null;
                });
    }

    /**
     * 获取接口的实现类
     *
     * @param interfaceClass 接口
     * @return 实现类
     */
    private Class<?> getImplementClass(final Class<?> interfaceClass) {
        return beanContainer.getClassesBySuper(interfaceClass)
                .stream()
                .findFirst()
                .orElse(null);
    }

}