package com.cgi.demo.search.service;

import com.cgi.demo.search.exception.YoutubeSearchContentException;
import com.cgi.demo.search.publisher.IRecordPublisher;
import com.cgi.demo.search.utils.Utils;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("Youtube")
public class YoutubeService implements IService {

    private final Logger LOG = LoggerFactory.getLogger(YoutubeService.class);

    @Value("${youtube.apikey}")
    String API_KEY;

    @Autowired
    IRecordPublisher<YoutubeModel> publisher;

    @Override
    public List<YoutubeModel> fetchVideosByQuery(String queryTerm) throws YoutubeSearchContentException {

        List<YoutubeModel> list = new ArrayList<>();
        try {

            YouTube youTube = Utils.getYouTubeApp();
            YouTube.Search.List search = youTube.search().list("id,snippet");
            search.setKey(API_KEY);
            search.setQ(queryTerm);
            search.setType("video");
            search.setFields("items(id/kind,id/videoId,snippet/title)");
            search.setMaxResults(40L);

            //perform the search and parse the results
            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();
            if (searchResultList != null) {
                for (SearchResult result : searchResultList) {
                    if (result.getSnippet().getTitle().contains(queryTerm)) {
                        String url = buildVideoUrl(result.getId().getVideoId());
                        String title = result.getSnippet().getTitle();
                        YoutubeModel model = new YoutubeModel(url, title);
                        publisher.publish(model);
                        list.add(model);
                    }
                }
            }
        } catch (Exception e) {
            throw new YoutubeSearchContentException("Exception in seacrh");
        }

        return list;
    }

    private String buildVideoUrl(String videoId) {
        StringBuilder builder = new StringBuilder();
        builder.append("https://www.youtube.com/watch?v=");
        builder.append(videoId);
        return builder.toString();
    }

}
