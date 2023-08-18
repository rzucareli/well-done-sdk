package com.zucareli.welldone.webclient;

import java.util.UUID;

public final class Data {
    private final UUID id;
    private final String name;


    public Data(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
