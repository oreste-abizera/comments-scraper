package rw.oreste.comments.server.controllers;

import org.springframework.web.bind.annotation.*;
import rw.oreste.comments.server.services.ChannelService;
import rw.oreste.comments.server.utils.ApiResponse;
import rw.oreste.comments.server.utils.dtos.SearchDTO;


import javax.validation.Valid;

@RestController
@RequestMapping("/channels")
public class ChannelController {

    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @PostMapping("/search")
    public ApiResponse search(@Valid @RequestBody SearchDTO searchDTO) {
        return ApiResponse.success(channelService.searchChannels(searchDTO));
    }
}
