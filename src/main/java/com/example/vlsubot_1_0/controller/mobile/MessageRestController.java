package com.example.vlsubot_1_0.controller.mobile;

import com.example.vlsubot_1_0.model.commonObject.responseObject.MessageResponse;
import com.example.vlsubot_1_0.service.WatsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MessageRestController {

    private WatsonService watsonService;

    @Autowired
    public MessageRestController(WatsonService watsonService) {
        this.watsonService = watsonService;
    }

    @PostMapping("/message")
    public MessageResponse postMessage(@RequestBody String messageText) {
        messageText = messageText.substring(1, messageText.length() - 1);
        return new MessageResponse(watsonService.sendMessage(messageText));
    }

}
