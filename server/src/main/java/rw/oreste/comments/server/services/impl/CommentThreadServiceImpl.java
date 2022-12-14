package rw.oreste.comments.server.services.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rw.oreste.comments.server.services.ChannelService;
import rw.oreste.comments.server.services.CommentThreadService;
import rw.oreste.comments.server.utils.ChannelsResponse;
import rw.oreste.comments.server.utils.CommentThreadsResponse;
import rw.oreste.comments.server.utils.dtos.ChannelDTO;
import rw.oreste.comments.server.utils.dtos.CommentThreadDTO;
import rw.oreste.comments.server.utils.dtos.CommentsSearchDTO;
import rw.oreste.comments.server.utils.dtos.SearchDTO;

import java.util.List;

@Service
public class CommentThreadServiceImpl implements CommentThreadService {
    @Value("${youtube.api.key}")
    String apiKey;

    @Override
    public List<CommentThreadDTO> searchComments(CommentsSearchDTO searchDTO) {
        String searchKeyword = searchDTO.getSearchKeyword();
        if(searchKeyword.compareTo("") == 4){
            searchKeyword = "";
        }
        RestTemplate restTemplate = new RestTemplate();
        Integer maxResults = searchDTO.getMaxResults();
        CommentThreadsResponse response;
        response = restTemplate.getForObject("https://youtube.googleapis.com/youtube/v3/commentThreads?part=snippet,replies&allThreadsRelatedToChannelId="+ searchDTO.getChannelId() +"&key="+apiKey+"&maxResults="+searchDTO.getMaxResults()+"&searchTerms="+searchKeyword, CommentThreadsResponse.class);
        while (response.getNextPageToken() != null && response.getItems().size() < maxResults) {
            CommentThreadsResponse nextPageResponse = restTemplate.getForObject("https://youtube.googleapis.com/youtube/v3/commentThreads?part=snippet,replies&allThreadsRelatedToChannelId="+ searchDTO.getChannelId() +"&key="+apiKey+"&maxResults="+searchDTO.getMaxResults()+"&searchTerms="+searchKeyword+"&pageToken="+response.getNextPageToken(), CommentThreadsResponse.class);
            response.getItems().addAll(nextPageResponse.getItems());
            response.setNextPageToken(nextPageResponse.getNextPageToken());
        }
        return response.getItems();
    }
}
