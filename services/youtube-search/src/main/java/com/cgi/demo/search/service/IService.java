package com.cgi.demo.search.service;

import com.cgi.demo.search.exception.YoutubeSearchContentException;

import java.util.List;

public interface IService {

    List<YoutubeModel> fetchVideosByQuery(String query) throws YoutubeSearchContentException;
}
