package com.harry0000.fit.event;

import com.harry0000.fit.message.DefinitionMessage;
import com.harry0000.fit.message.FileId;

@FunctionalInterface
public interface FileIdListener {

    void onMessage(final DefinitionMessage defMsg, final FileId msg);

}
