package com.cgi.demo.search.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Qualifier("facebook")
public class FaceBookService implements IService {

    private final Logger LOG = LoggerFactory.getLogger(FaceBookService.class);

    @Override
    public List<YoutubeModel> fetchVideosByQuery(String query) {
        LOG.warn("No face book post found");
        return Collections.EMPTY_LIST;
    }
}
