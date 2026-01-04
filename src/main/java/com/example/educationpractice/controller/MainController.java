package com.example.educationpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/mains")
    public class MainController {

        @GetMapping()
        public String indexPage() {
            return "main/index";
        }

        @GetMapping("/students")
        public String studentsPage() {
            return "students/index";
        }

        @GetMapping("/teachers")
        public String teachersPage() {
            return "teachers/index";
        }
    }


