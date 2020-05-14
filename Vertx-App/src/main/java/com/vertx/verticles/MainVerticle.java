package com.vertx.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;

public class MainVerticle  extends AbstractVerticle {


    @Override
    public void start(Future<Void> future) throws Exception {
        Router  router =Router.router(vertx);
         vertx.createHttpServer().requestHandler(router).
                 listen(8001,resp ->
         {
             if(resp.succeeded()) {
                 System.out.println("Main Verticle");
                 future.complete();
             }
             else {
                 future.failed();
             }
         });



    }
}
