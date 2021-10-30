package com.cozwork.application.message;

import com.cozwork.domain.command.Command;

public interface RequestToCommand {
    Command toCommand();
}