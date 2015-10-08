package com.harry0000.fit.event;

import com.harry0000.fit.message.DefinitionMessage;
import com.harry0000.fit.message.Session;

@FunctionalInterface
public interface SessionListener {

    void onMessage(final DefinitionMessage defMsg, final Session msg);

}
