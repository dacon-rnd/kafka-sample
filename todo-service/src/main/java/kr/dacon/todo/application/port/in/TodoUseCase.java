package kr.dacon.todo.application.port.in;

public interface TodoUseCase {
    void newTodo(TodoCommand todoCommand);
}
