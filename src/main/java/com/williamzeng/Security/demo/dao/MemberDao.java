package com.williamzeng.Security.demo.dao;

import java.util.List;

import com.williamzeng.Security.demo.model.Member;
import com.williamzeng.Security.demo.model.Role;

public interface MemberDao {

    Member getMemberById(Integer memberId);

    Member getMemberByEmail(String email);

    Integer createMember(Member member);

    List<Role> getRolesByMemberId(Integer memberId);
    
}
