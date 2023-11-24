package com.mymolu.domains.crawling.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CrawlingServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CrawlingService crawlingService;

        @DisplayName("픽시브 이미지 크롤링 테스트")
            @Test
            void CrawlingServiceTest() throws InterruptedException {
                // given
                crawlingService.getImages();
                // when

                // then

            }
}