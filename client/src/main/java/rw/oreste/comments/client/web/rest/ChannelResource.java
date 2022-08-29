package rw.oreste.comments.client.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import rw.oreste.comments.client.utils.ApiResponse;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
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

    @GetMapping("/list")
    public String listChannels() {
        return "channels/list";
    }

    @PostMapping("/search")
    public String searchChannel(HttpServletRequest request, Model model){
        String searchKeyword = request.getParameter("searchKeyword");
        if(Objects.isNull(searchKeyword)){
            model.addAttribute("message", "Please enter a search keyword");
            return "redirect:/channels/search";
        }
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("searchKeyword", searchKeyword);

        HttpEntity requestEntity = new HttpEntity(requestBody);
        ApiResponse response = restTemplate.postForObject(formatURL("channels/search"), requestEntity, ApiResponse.class);
        if(!response.isSuccess()){
            model.addAttribute("message", response.getMessage());
            return "redirect:/channels/search";
        }
        model.addAttribute("channels", response.getData());
        return "channels/list";
    }
}
