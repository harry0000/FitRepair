package com.harry0000.fit.event;

import com.harry0000.fit.message.Activity;
import com.harry0000.fit.message.DefinitionMessage;

@FunctionalInterface
public interface ActivityListener {

    void onMessage(final DefinitionMessage defMsg, final Activity msg);

}
