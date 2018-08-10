package com.flash.flashbootstarter.mvc.render;

import com.flash.flashbootstarter.mvc.handler.RequestHandlerChain;

/**
 * 渲染请求结果 interface
 *
 */
public interface Render {
    /**
     * 执行渲染
     *
     * @param handlerChain {@link RequestHandlerChain}
     * @throws Exception Exception
     */
    void render(RequestHandlerChain handlerChain) throws Exception;
}
