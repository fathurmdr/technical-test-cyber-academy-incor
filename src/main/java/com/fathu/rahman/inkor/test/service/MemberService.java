package com.fathu.rahman.inkor.test.service;

import com.fathu.rahman.inkor.test.entity.Member;
import com.fathu.rahman.inkor.test.model.CreateMemberRequest;
import com.fathu.rahman.inkor.test.model.UpdateMemberRequest;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    void create(CreateMemberRequest request);

    Optional<Member> getDetail(Integer id);

    void update(Integer id, UpdateMemberRequest request);

    void delete(Integer id);

    List<Member> getList();
}
