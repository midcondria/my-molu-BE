package com.mymolu.domains.student.presentation;

import com.mymolu.domains.crawling.application.CrawlingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentController {

    private final CrawlingService crawlingService;

    @GetMapping("/students")
    public List<String> getStudents() {
        return crawlingService.downloadImages();
    }
}
