package com.zucareli.welldone.webclient;

import java.util.Collection;

public interface WellDoneClient {

    Collection<Data> list(ListRequest request);

    Data get(GetRequest request);

}
