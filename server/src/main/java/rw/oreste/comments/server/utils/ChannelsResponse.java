package rw.oreste.comments.server.utils;


import lombok.Data;
import rw.oreste.comments.server.utils.dtos.ChannelDTO;

import java.util.List;

@Data
public class ChannelsResponse {
    private String kind;
    private String etag;
    private List<ChannelDTO> items;
    private PageInfo pageInfo;
    private String regionCode;
}
