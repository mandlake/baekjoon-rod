package com.rod.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl service;

    @PostMapping("/login")
    public Map<String, ?> id(@RequestBody Map<String, ?> map) {
        String id = (String)map.get("id");
        String pw = (String)map.get("pw");
        System.out.println("리퀘스트가 가져온 아이디 : " + id);
        Map<String, String> respMap = new HashMap<>();
        respMap.put("id", id);
        respMap.put("pw", pw);
        return respMap;
    }
}
