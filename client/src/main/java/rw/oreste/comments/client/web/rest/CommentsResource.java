package rw.oreste.comments.client.web.rest;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import rw.oreste.comments.client.dao.ChannelDTO;
import rw.oreste.comments.client.dao.CommentThreadDTO;
import rw.oreste.comments.client.utils.ApiResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

import static rw.oreste.comments.client.utils.Utility.formatURL;


@Controller
@RequestMapping("/channels/view/{channelId}/comments")
public class CommentsResource {


    @GetMapping
    public String index(@PathVariable String channelId, Model model, HttpServletRequest request) {
        Integer limit = request.getParameter("limit") == null ? 20 : Integer.parseInt(request.getParameter("limit"));
        String searchKeyword = request.getParameter("searchKeyword");
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("channelId", channelId);
        requestBody.put("maxResults", limit.toString());
        requestBody.put("searchKeyword", searchKeyword);
        HttpEntity requestEntity = new HttpEntity(requestBody);
        try {
        ApiResponse response = restTemplate.postForObject(formatURL("/comments/search"), requestEntity, ApiResponse.class);
        if(!response.isSuccess()){
            model.addAttribute("error", response.getMessage());
            return "/channels/viewComments";
        }
        ArrayList<?> commentThreads = (ArrayList<CommentThreadDTO>) response.getData();
        // search by keyword
        model.addAttribute("comments", commentThreads);
        model.addAttribute("limit", limit);
        model.addAttribute("searchKeyword", searchKeyword);
        return "channels/viewComments";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "/channels/viewComments";
        }
    }


}
