package rw.oreste.comments.client.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import rw.oreste.comments.client.dao.ChannelDTO;
import rw.oreste.comments.client.utils.ApiResponse;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static rw.oreste.comments.client.utils.Utility.formatURL;


@Controller
@RequestMapping("/channels/")
public class ChannelResource {

    @GetMapping("/search")
    public String searchChannel() {
        return "/channels/search";
    }

    @GetMapping("/view/{channelId}")
    public String viewChannel(@PathVariable String channelId, Model model) {
        model.addAttribute("channelId", channelId);
        return "/channels/view";
    }

    @PostMapping("/search")
    public String searchChannel(HttpServletRequest request, Model model){
        String searchKeyword = request.getParameter("searchKeyword");
        if(searchKeyword == null || searchKeyword.isEmpty() || searchKeyword.trim().isEmpty()){
            model.addAttribute("error", "Please enter a search keyword");
            model.addAttribute("searchKeyword", searchKeyword);
            return "/channels/search";
        }
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("searchKeyword", searchKeyword);

        HttpEntity requestEntity = new HttpEntity(requestBody);
        try {
        ApiResponse response = restTemplate.postForObject(formatURL("/channels/search"), requestEntity, ApiResponse.class);
        if(!response.isSuccess()){
            model.addAttribute("error", response.getMessage());
            model.addAttribute("searchKeyword", searchKeyword);
            return "/channels/search";
        }
        List<ChannelDTO> channels = (List<ChannelDTO>) response.getData();
        model.addAttribute("channels", channels);
        model.addAttribute("searchKeyword", searchKeyword);
        return "channels/search";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
            model.addAttribute("searchKeyword", searchKeyword);
            return "/channels/search";
        }
    }
}
