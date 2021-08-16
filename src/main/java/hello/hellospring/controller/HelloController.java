package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Spring!!");
        return "hello"; // templates 폴더의 hello.html을 렌더링
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // View를 조회하는 것이 아닌 문자 그대로 응답
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello spring"
    }

    // API 방식 - 자동으로 JSON 객체로 응답
    @GetMapping("hello-api")
    @ResponseBody // 객체 반환 시 기본으로 JSON으로 반환
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        // Getter Setter: Java bean 규약
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
