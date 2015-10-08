package com.harry0000.fit.event;

import com.harry0000.fit.message.DefinitionMessage;

@FunctionalInterface
public interface DefinitionMessageListener {

    void onDefinitionMessage(final DefinitionMessage msg);

}
