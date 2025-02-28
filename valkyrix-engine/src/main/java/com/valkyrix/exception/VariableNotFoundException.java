package com.valkyrix.exception;

public class VariableNotFoundException extends RuntimeException {
    private final String varName;

    public VariableNotFoundException(String varName) {
        super("Variable '" + varName + "' not found in context");
        this.varName = varName;
    }

    public String getVarName() {
        return varName;
    }
}