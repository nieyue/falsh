package com.flash.flashbootstarter.mvc.render;

import com.flash.flashbootstarter.mvc.handler.RequestHandlerChain;

import javax.servlet.http.HttpServletResponse;

/**
 * 渲染404
 *
 */
public class NotFoundRender implements Render {


    @Override
    public void render(RequestHandlerChain handlerChain) throws Exception {
        handlerChain.getResponse().sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}
