package com.harry0000.fit.event;

import com.harry0000.fit.message.DefinitionMessage;
import com.harry0000.fit.message.Lap;

@FunctionalInterface
public interface LapListener {

    void onMessage(final DefinitionMessage defMsg, final Lap msg);

}
