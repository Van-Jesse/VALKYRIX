package com.valkyrix.executor;

public class ExpExecutorService {

    private final String exp;

    public ExpExecutorService(String exp) {
        this.exp = exp;
    }

    public boolean execute(){
        System.out.println(exp);
        return true;
    };
}
