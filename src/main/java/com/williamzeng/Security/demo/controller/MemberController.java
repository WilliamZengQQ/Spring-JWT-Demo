package com.williamzeng.Security.demo.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.williamzeng.Security.demo.dao.MemberDao;
import com.williamzeng.Security.demo.model.Member;




@RestController
public class MemberController {
    
   
     @Autowired
     private MemberDao memberDao;

     @Autowired
     private PasswordEncoder passwordEncode; 

    @PostMapping("/register")
    public Member register(@RequestBody Member member){

        //hash原始密碼
        String hashedPassword = passwordEncode.encode(member.getPassword());
        member.setPassword(hashedPassword);
        /*
         ＊可以補上參數檢查功能（ex email是否有被註冊過）
         */

        //在資料庫中插入Member數據
        Integer memberId = memberDao.createMember(member); 



        return memberDao.getMemberById(memberId);
    }
}
