package org.all4.skimate.skiRounge.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.all4.skimate.skiRounge.domain.Ski;
import org.all4.skimate.skiRounge.service.SkiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SkiController {

    private final SkiService skiService;


    @GetMapping("/api/skiRounge")
    public List<Ski> skiList(){

        List<Ski> skis = skiService.skiList();
        return skis;
    }
}
