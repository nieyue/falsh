package com.flash.flashbootstarter.mvc.render;

import com.flash.flashbootstarter.mvc.handler.RequestHandlerChain;

/**
 * 默认渲染 200
 *
 */
public class DefaultRender implements Render {

    @Override
    public void render(RequestHandlerChain handlerChain) throws Exception {
        int status = handlerChain.getResponseStatus();
        handlerChain.getResponse().setStatus(status);
    }
}
