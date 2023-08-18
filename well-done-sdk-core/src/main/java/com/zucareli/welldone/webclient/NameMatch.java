package com.zucareli.welldone.webclient;

public enum NameMatch {
    EQUAL("eq"), STARTS_WITH("sw"), ENDS_WITH("ew");

    private final String value;

    NameMatch(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
