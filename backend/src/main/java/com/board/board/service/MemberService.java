package com.board.board.service;

import com.board.board.dto.MemberDTO;
import com.board.board.entity.MemberEntity;
import com.board.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // 생성자주입 방법설정
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    public String save(MemberDTO memberDTO) {
        // 1. dto -> entity 변환
        // 2. repository의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
        return "ok";
    }
    // 이메일 중복체크
    public String emailCheck(String memberEmail) {
        // Optional<>을 사용하면 null값으로인해 발생하는 예외처리가능
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberEmail);
            if (byMemberEmail.isPresent()) {
                // 조회결과가 있다 -> 사용할 수 없다.
                return null;
            }
            else {
                // 조회결과가 없다 -> 사용할 수 있다.
                return "ok";
            }
        }


    // 로그인
    public String login(MemberDTO memberDTO) {
        /*
            1. 회원이 입력한 이메일로 DB에서 조회를 함
            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
        */
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if (byMemberEmail.isPresent()) {
            // 이메일 조회 결과가 있다면
            MemberEntity memberEntity = byMemberEmail.get();
            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                // 비밀번호 일치
                // entity -> dto 변환 후 리턴
//                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return "ok";
            } else {
                // 비밀번호 불일치
                return null;
            }
        } else {
            // 이메일 조회 결과가 없다면
            return null;
        }
    }

    // 전체 회원정보 조회
    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for (MemberEntity memberEntity: memberEntityList) {
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
        }
        return memberDTOList;
    }

//
//    public MemberDTO findById(Long id) {
//        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
//        if (optionalMemberEntity.isPresent()) {
//            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
//        }else {
//            return null;
//        }
//    }
//
//    public MemberDTO updateForm(String myEmail) {
//        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberEmail(myEmail);
//        if(optionalMemberEntity.isPresent()) {
//            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
//        } else {
//            return null;
//        }
//    }
//
//    public void update(MemberDTO memberDTO) {
//        memberRepository.save(MemberEntity.toMemberEntity(memberDTO));
//    }
//
//    public void deleteById(Long id) {
//        memberRepository.deleteById(id);
//    }
}
