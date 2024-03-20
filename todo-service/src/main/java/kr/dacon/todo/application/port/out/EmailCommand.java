package kr.dacon.todo.application.port.out;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EmailCommand {
    private String body;
}
