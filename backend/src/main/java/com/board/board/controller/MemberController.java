package com.board.board.controller;

import com.board.board.dto.MemberDTO;
import com.board.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:8585, http://localhost:8080")

public class MemberController {

    private final MemberService memberService;

    // 회원 목록 (list라는 페이지에 값을 넘기는 방식 사용)
    @GetMapping("/member/get")
    public List<MemberDTO> findAll(Model model) {
        return memberService.findAll();
    }

    //회원가입
    @PostMapping("/member/save") // 값을 받아올 페이지
    public String save(@RequestBody @Valid MemberDTO memberDTO) {
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        return memberService.save(memberDTO);
    }

    // 이메일 중복체크
    @PostMapping("/member/email-check")
    public String emailCheck(@RequestParam("memberEmail") String memberEmail) {
        System.out.println("memberEmail = " + memberEmail);
        String checkResult = memberService.emailCheck(memberEmail);
        return checkResult;
    }

    // 로그인
    @PostMapping("/member/login")
    public String login(@RequestBody MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        return memberService.login(memberDTO);
    }

        // 회원정보 수정, update Html 리턴
//    @GetMapping("/member/update")
//    public String updateForm(HttpSession session, Model model) {
//        String myEmail = (String) session.getAttribute("loginEmail");
//        MemberDTO memberDTO = memberService.updateForm(myEmail);
//        model.addAttribute("updateMember", memberDTO);
//        return "update";
//    }

//
//    // 회원상세 조회 detail Html 리턴
//    @GetMapping("/member/{id}")
//    public String findById(@PathVariable Long id, Model model) {
//        MemberDTO memberDTO = memberService.findById(id);
//        model.addAttribute("member", memberDTO);
//        return  "detail";
//    }
//
//
//    @PostMapping("/member/update")
//    public String update(@ModelAttribute MemberDTO memberDTO) {
//        memberService.update(memberDTO);
//        return "redirect:/member/" + memberDTO.getId();
//    }
//
//    @GetMapping("/member/delete/{id}")
//    public String deleteById(@PathVariable Long id) {
//        memberService.deleteById(id);
//        return "redirect:/member/";
//    }
//
}
