package com.bindstone;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcessingService {

    public OutputObject process(InputObject input) {
        String result = input.getName().toUpperCase();
        OutputObject out = new OutputObject();
        out.setResult(result);
        return out;
    }
}
