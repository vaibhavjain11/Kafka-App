package com.cgi.demo.search.controller;

import com.cgi.demo.search.VideoApp;
import com.cgi.demo.search.VideoFactory;
import com.cgi.demo.search.exception.YoutubeSearchContentException;
import com.cgi.demo.search.service.IService;
import com.cgi.demo.search.service.YoutubeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class YoutubeController {


    @RequestMapping(value = "/youtubesearch", method = RequestMethod.GET)
    public ResponseEntity searchYouTubeVideos(@RequestParam("query") String query) {

        try {
            IService service = VideoFactory.buildVideoFactoryInstance(VideoApp.YOUTUBE);
            List<YoutubeModel> models = service.fetchVideosByQuery(query);
            return new ResponseEntity(models, HttpStatus.OK);
        } catch (YoutubeSearchContentException e) {
            return new ResponseEntity("Exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
