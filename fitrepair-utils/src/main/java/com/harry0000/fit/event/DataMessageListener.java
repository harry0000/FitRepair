package com.harry0000.fit.event;

import com.harry0000.fit.message.DataMessage;
import com.harry0000.fit.message.DefinitionMessage;

@FunctionalInterface
public interface DataMessageListener {

    void onMessage(final DefinitionMessage defMsg, final DataMessage msg);

}
