package rw.oreste.comments.server.services;

import rw.oreste.comments.server.utils.dtos.ChannelDTO;
import rw.oreste.comments.server.utils.dtos.SearchDTO;

import java.util.List;

public interface ChannelService {
    List<ChannelDTO> searchChannels(SearchDTO searchDTO);
}
