package rw.oreste.comments.server.services;

import rw.oreste.comments.server.utils.dtos.SearchDTO;

import java.util.List;

public interface ChannelService {
    List<?> searchChannels(SearchDTO searchDTO);
}
