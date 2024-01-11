package com.ll.mediumforpractice.domain.home.home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adm")
@RequiredArgsConstructor
public class AdmHomeController {
    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public String showMain() {
        return "domain/home/home/adm/main";
    }

    @GetMapping("/home/about")
    @PreAuthorize("hasRole('ADMIN')")
    public String showAbout() {
        return "domain/home/home/adm/about";
    }
}
