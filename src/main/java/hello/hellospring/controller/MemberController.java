package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

//    @Autowired // Setter 주입
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    // 생성자 주입
    @Autowired // 스프링 컨테이너에 있는 memberService와 자동으로 연결 // Controller -> Service -> Repository
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
