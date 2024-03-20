package kr.dacon.todo.adapter.in.web;

import kr.dacon.common.WebAdaptor;
import kr.dacon.todo.application.port.in.TodoCommand;
import kr.dacon.todo.application.port.in.TodoUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdaptor
@RestController
@Slf4j
public class TodoController {

    @Autowired
    private TodoUseCase todoUseCase;

    @PostMapping(path="/todo/new")
    void registerTodo(@RequestBody TodoRequest request) {
        TodoCommand todoCommand = TodoCommand.builder()
                .message(request.getMessage())
                .build();
        todoUseCase.newTodo(todoCommand);
    }
}
