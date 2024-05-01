package org.ferhat.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/")
public class TestController {

    @GetMapping("/")
    public String home() {
        return "Hello Spring Boot";
    }

    @GetMapping("/about")
    public String about() {
        return "Your Knowledge";
    }

    @GetMapping("/user/{userId}/{userName}")
    public String getUser(@PathVariable("userId") int user_id, @PathVariable("userName") String user_name){
        return "user id : " + user_id + " user name : " + user_name;
    }

}
