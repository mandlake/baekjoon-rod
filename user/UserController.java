package com.rod.api.user;

import com.rod.api.messanger.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository repository;

    @PostMapping(path = "/api/login")
    public Map<String, ?> id(@RequestBody Map<String, ?> map) {
        Map<String, Messenger> respMap = new HashMap<>();
        User optUser = repository.findByUsername((String) map.get("id")).orElse(null);
        if(optUser == null) {
            respMap.put("message", Messenger.FAIL);
        } else if(!optUser.getPassword().equals(map.get("pw"))) {
            respMap.put("message", Messenger.WRONG_PASSWORD);
        } else {
            respMap.put("message", Messenger.SUCCESS);
        }

        return respMap;
    }

    @PostMapping(path = "/api/join")
    private Map<String, ?> join(@RequestBody Map<String, ?> map) {
        Map<String, Messenger> respMap = new HashMap<>();
        repository.save(User.builder()
                .username((String) map.get("id"))
                .password((String) map.get("pw"))
                .name((String) map.get("name"))
                .phoneNumber((String) map.get("phone"))
                .address((String) map.get("address"))
                .job((String) map.get("job"))
                .height(Double.parseDouble((String) map.get("height")))
                .weight(Double.parseDouble((String) map.get("weight")))
                .build());
        System.out.println(respMap);
        respMap.put("message", Messenger.SUCCESS);
        return respMap;
    }
}
