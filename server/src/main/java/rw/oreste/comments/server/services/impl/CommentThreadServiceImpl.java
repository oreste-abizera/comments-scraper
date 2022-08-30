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
        RestTemplate restTemplate = new RestTemplate();
        CommentThreadsResponse res = restTemplate.getForObject("https://youtube.googleapis.com/youtube/v3/commentThreads?part=snippet,replies&allThreadsRelatedToChannelId="+ searchDTO.getChannelId() +"&key="+apiKey, CommentThreadsResponse.class);
        return res.getItems();
    }
}
