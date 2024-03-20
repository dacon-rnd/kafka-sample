package kr.dacon.todo.application.service;

import kr.dacon.todo.application.port.in.TodoCommand;
import kr.dacon.todo.application.port.in.TodoUseCase;
import kr.dacon.todo.application.port.out.EmailCommand;
import kr.dacon.todo.application.port.out.EmailPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class TodoService implements TodoUseCase {
    @Autowired
    private EmailPort emailPort;

    @Override
    public void newTodo(TodoCommand todoCommand) {
        log.info("new message {}", todoCommand);
        emailPort.sendEmail(EmailCommand.builder().body(todoCommand.getMessage()).build());
    }
}

