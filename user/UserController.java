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
        String id = (String)map.get("id");
        String pw = (String)map.get("pw");
        System.out.println("리퀘스트가 가져온 아이디 : " + id);
        Map<String, String> respMap = new HashMap<>();
        respMap.put("id", id);
        respMap.put("pw", pw);
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
