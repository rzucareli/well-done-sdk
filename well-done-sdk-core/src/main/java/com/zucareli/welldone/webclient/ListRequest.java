package com.zucareli.welldone.webclient;

import java.util.Optional;

public final class ListRequest {
    private final Optional<String> name;
    private final Optional<NameMatch> nameMatch;

    public ListRequest(String name, NameMatch nameMatch) {
        this.name = Optional.ofNullable(name);
        this.nameMatch = Optional.ofNullable(nameMatch);
    }

    public Optional<String> getName() {
        return name;
    }

    public Optional<NameMatch> getNameMatch() {
        return nameMatch;
    }
}
