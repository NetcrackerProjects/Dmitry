package ru.titov.taskmanagerserver.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response {

    private boolean success = true;

    private String message = "[OK]";

}
