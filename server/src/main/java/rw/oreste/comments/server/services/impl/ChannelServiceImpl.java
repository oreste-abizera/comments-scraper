package rw.oreste.comments.server.services.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rw.oreste.comments.server.services.ChannelService;
import rw.oreste.comments.server.utils.ChannelsResponse;
import rw.oreste.comments.server.utils.dtos.ChannelDTO;
import rw.oreste.comments.server.utils.dtos.SearchDTO;

import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {
    @Value("${youtube.api.key}")
    String apiKey;

    @Override
    public List<ChannelDTO> searchChannels(SearchDTO searchDTO) {
        String searchKeyword = searchDTO.getSearchKeyword();
        RestTemplate restTemplate = new RestTemplate();
        ChannelsResponse res = restTemplate.getForObject("https://www.googleapis.com/youtube/v3/search?part=snippet&q=" + searchKeyword + "&type=channel&key="+apiKey, ChannelsResponse.class);
        return res.getItems();
    }
}
