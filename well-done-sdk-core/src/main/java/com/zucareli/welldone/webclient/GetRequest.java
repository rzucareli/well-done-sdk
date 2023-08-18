package com.zucareli.welldone.webclient;

import java.util.UUID;

public final class GetRequest {
    private final UUID id;

    public GetRequest(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
