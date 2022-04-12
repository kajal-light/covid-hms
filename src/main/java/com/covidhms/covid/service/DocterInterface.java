package com.covidhms.covid.service;

import com.covidhms.covid.domain.request.DocterRequest;
import com.covidhms.covid.domain.response.DocterResponse;

public interface DocterInterface {
    String create(DocterRequest docterRequest);

    DocterResponse getUser(String id);
}
