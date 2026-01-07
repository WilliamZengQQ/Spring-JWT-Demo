package com.williamzeng.Security.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.williamzeng.Security.demo.model.Student;;

@RestController
public class StudentController {
    @PostMapping("/students")
    public String create(@RequestBody Student student) {
        return "在資料庫中插入一筆 Student 數據";
    }

    @GetMapping("/students/{studentId}")
    public String read(@PathVariable Integer studentId,
                       @RequestBody Student student) {
        return "從資料庫中讀取 Student 數據";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student) {
        return "更新資料庫中的 Student 數據";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        return "刪除資料庫中的 Student 數據";
    }
}
