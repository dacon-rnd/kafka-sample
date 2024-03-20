package kr.dacon.todo.application.port.out;

import kr.dacon.todo.adapter.out.service.EmailServiceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface EmailPort {
    void sendEmail(EmailCommand build);
}
