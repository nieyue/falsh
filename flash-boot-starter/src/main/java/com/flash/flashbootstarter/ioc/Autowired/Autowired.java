package com.flash.flashbootstarter.ioc.Autowired;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 依赖注入：1.构造注入(Constructor Injection)2.设值方法注入(Setter Injection)3.接口注入(Interface Injection)
 *目前采用接口注入，构造注入会出现循环依赖
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
}