package com.vertx.app;

import com.vertx.verticles.MainVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

public class VertxApplication {


    public static void main(String[] args) {
        Vertx  vertx =Vertx.vertx();

        DeploymentOptions  deploymentOptions  = new DeploymentOptions();


        vertx.deployVerticle(new MainVerticle(),deploymentOptions,resp -> {

                if(resp.succeeded())
                {
                    System.out.println("deployed succesfully");
                }
                else {
                    System.out.println("deployed failed"+resp.cause());

                }
    }
    );

        System.out.println("future completed");
    }
}


