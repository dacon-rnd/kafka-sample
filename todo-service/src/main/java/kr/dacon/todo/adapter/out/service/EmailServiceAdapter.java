package kr.dacon.todo.adapter.out.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.dacon.common.CommonHttpClient;
import kr.dacon.todo.application.port.out.EmailCommand;
import kr.dacon.todo.application.port.out.EmailPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailServiceAdapter implements EmailPort{
    private final CommonHttpClient commonHttpClient;

    private final String emailServiceUrl;

    @Autowired
    private ObjectMapper mapper;

    public EmailServiceAdapter(CommonHttpClient commonHttpClient,
                                    @Value("${service.email.url}") String emailServiceUrl) {
        this.commonHttpClient = commonHttpClient;
        this.emailServiceUrl = emailServiceUrl;
    }

    @Override
    public void sendEmail(EmailCommand emailCommand) {
        log.info(emailServiceUrl);
        try {
            commonHttpClient.sendPostRequest(emailServiceUrl + "/email/new", mapper.writeValueAsString(emailCommand));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
