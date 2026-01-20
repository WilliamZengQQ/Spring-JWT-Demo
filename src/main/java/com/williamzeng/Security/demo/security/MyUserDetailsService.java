package com.williamzeng.Security.demo.security;


import com.williamzeng.Security.demo.model.Member;

import java.util.ArrayList;
import java.util.List;


import com.williamzeng.Security.demo.model.Role;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.williamzeng.Security.demo.dao.MemberDao;
 
@Component
public class MyUserDetailsService implements UserDetailsService {

    private final static Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);


    @Autowired
    private MemberDao memberDao;

    private List<GrantedAuthority> convertToAuthorities(List<Role> roleList) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roleList) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return authorities;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        //從資料庫中查詢member數據
        Member member = memberDao.getMemberByEmail(username);
        if (member == null) {
            throw new UsernameNotFoundException("Member not found:"+username);
        }
        else{
            String memberEmail = member.getEmail();
            String memberPassword = member.getPassword();
            logger.info(" memberEmail為{}並且memberPassword是{}",memberEmail,memberPassword);
            //權限部分

            List<Role> roleList = memberDao.getRolesByMemberId(member.getMemberId());

            List<GrantedAuthority> authorities = convertToAuthorities(roleList);
            return new User(memberEmail, memberPassword,authorities);
        } //回傳至spring security的數值（帳號,密碼,權限)
        
    }


    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     // TODO: 去資料庫用 email/username 查 member
    //     throw new UsernameNotFoundException("User not found: " + username);
    // }

    
}