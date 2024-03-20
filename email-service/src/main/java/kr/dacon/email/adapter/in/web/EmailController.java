package kr.dacon.email.adapter.in.web;

import kr.dacon.common.WebAdaptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdaptor
@RestController
@Slf4j
public class EmailController {

    @PostMapping(path="/email/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    void sendEmail(@RequestBody EmailRequest request) {
        log.info("email : "+request);
    }
}
