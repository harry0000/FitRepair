package com.harry0000.fit.event;

import com.harry0000.fit.message.DefinitionMessage;
import com.harry0000.fit.message.Length;

@FunctionalInterface
public interface LengthListener {

    void onMessage(final DefinitionMessage defMsg, final Length msg);

}
