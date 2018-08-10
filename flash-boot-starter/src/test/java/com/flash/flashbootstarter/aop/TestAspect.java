package com.flash.flashbootstarter.aop;

import com.flash.flashbootstarter.aop.advice.AroundAdvice;
import com.flash.flashbootstarter.aop.annotation.Aspect;
import com.flash.flashbootstarter.aop.annotation.Order;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@Slf4j
@Order(1)
@Aspect(pointcut = "execution(* com.flash.flashbootstarter.controller.TestController.helloForAspect(..))")
public class TestAspect implements AroundAdvice {


	@Override
	public void afterReturning(Class<?> clz, Object returnValue, Method method, Object[] args) throws Throwable {
		log.info("111111");

	}

	@Override
	public void before(Class<?> clz, Method method, Object[] args) throws Throwable {
		log.info("2222");
	}

	@Override
	public void afterThrowing(Class<?> clz, Method method, Object[] args, Throwable e) {
		log.info("333333");
	}
}