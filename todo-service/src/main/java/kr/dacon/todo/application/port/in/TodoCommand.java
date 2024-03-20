package kr.dacon.todo.application.port.in;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class TodoCommand {
    private String message;
}
