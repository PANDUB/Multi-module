package com.vertx.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

public class CustomerVerticle  extends AbstractVerticle {
    public static String EVENT_ADDRESS="custom.bus";
    @Override
    public void start(Future<Void> startFuture) throws Exception {

        vertx.eventBus().<JsonObject>consumer(EVENT_ADDRESS, this::handler);

    }
    public void handler(final Message<JsonObject> jsonObjectMessage)
    {
      jsonObjectMessage.body();
      jsonObjectMessage.reply("succeed");

    }
}
