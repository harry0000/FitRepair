package com.harry0000.fit.event;

import com.harry0000.fit.message.DefinitionMessage;
import com.harry0000.fit.message.Event;

@FunctionalInterface
public interface EventListener {

    void onMessage(final DefinitionMessage defMsg, final Event msg);

}
