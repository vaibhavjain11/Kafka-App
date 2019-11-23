package com.cgi.demo.search;

import com.cgi.demo.search.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class VideoFactory {

    @Autowired
    @Qualifier("Youtube")
    private static IService youtubeService;

    @Autowired
    @Qualifier("facebook")
    private static IService facebookService;

    public static IService buildVideoFactoryInstance(VideoApp app) {

        switch (app) {

            case YOUTUBE:
                return youtubeService;
            case PRIME_VIDEO:
            case NETFLIX:
            case FACEBOOK:
                return facebookService;

        }

        return null;
    }
}
