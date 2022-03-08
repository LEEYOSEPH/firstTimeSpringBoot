package com.first.springboot;

import com.first.springboot.web.HelloController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class) // 테스트를 진행할때 JUnit에 내장된 실행자외에 다른 실행자를 실행시킨다.
                                    // 스프링부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class)  // 선언할 경우 @Controller, @ControllerAdvice등을 사용 가능
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 Bean 주입 받음
    private MockMvc mvc; // 웹 API 테스트 할때 사용, 스프링 MVC테스트의 시작점

    @Test
    public void helloReturn() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
}
