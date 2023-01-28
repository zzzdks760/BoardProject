package com.board.board.controller;

import com.board.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;

    //회원가입 페이지

}
