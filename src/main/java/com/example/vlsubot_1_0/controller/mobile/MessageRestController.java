package com.example.vlsubot_1_0.controller.mobile;

import com.example.vlsubot_1_0.model.commonObject.responseObject.MessageResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MessageRestController {

    @PostMapping("/message")
    public MessageResponse postMessage(@RequestBody String messageText) {
        return new MessageResponse("This is mocked server response, so dont try to kill the actual bot )). And you sent this to server " + messageText);
    }

}
