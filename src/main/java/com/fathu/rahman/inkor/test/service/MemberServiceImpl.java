package com.fathu.rahman.inkor.test.service;

import com.fathu.rahman.inkor.test.entity.Member;
import com.fathu.rahman.inkor.test.model.CreateMemberRequest;
import com.fathu.rahman.inkor.test.model.UpdateMemberRequest;
import com.fathu.rahman.inkor.test.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void create(CreateMemberRequest request){
        Member member = new Member();

        member.setName(request.getName());
        member.setDateOfBirth(request.getDateOfBirth());
        member.setEducation((request.getEducation()));
        member.setEmail(request.getEmail());
        member.setMobileNumber(request.getMobileNumber());

        memberRepository.save(member);
    }

    @Override
    public Optional<Member> getDetail(Integer id){
        Optional<Member> member = memberRepository.findById(id);

        return member;
    }

    @Override
    public void update(Integer id, UpdateMemberRequest request){
        Member member  = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member Id:" + id));

        member.setName(request.getName());
        member.setDateOfBirth(request.getDateOfBirth());
        member.setEducation((request.getEducation()));
        member.setEmail(request.getEmail());
        member.setMobileNumber(request.getMobileNumber());

        memberRepository.save(member);
    }

    @Override
    public void delete(Integer id){
        memberRepository.deleteById(id);
    }

    @Override
    public List<Member> getList(){
        List<Member> members = memberRepository.findAll();

        return members;
    }
}
