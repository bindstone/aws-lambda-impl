package com.bindstone;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.cloud.function.context.catalog.FunctionTypeUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Map;
import java.util.function.Function;

@SpringBootApplication
public class Handler implements ApplicationContextInitializer<GenericApplicationContext> {

    public Function<String, String> uppercase() {
        return value -> {
            var builder = new GsonBuilder();
            var gson = builder.create();
            var map = gson.fromJson(value, Map.class);
            return map.get("name").toString().toUpperCase();
        };
    }

    @Override
    public void initialize(GenericApplicationContext context) {
        context.registerBean("uppercase", FunctionRegistration.class,
                () -> new FunctionRegistration<>(uppercase())
                        .type(FunctionTypeUtils.functionType(String.class,String.class)));
    }

    public static void main(String[] args) {
        FunctionalSpringApplication.run(Handler.class, args);
    }
}

