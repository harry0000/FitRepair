package com.harry0000.fit.event;

import com.harry0000.fit.message.DefinitionMessage;
import com.harry0000.fit.message.Hrv;

@FunctionalInterface
public interface HrvListener {

    void onMessage(final DefinitionMessage defMsg, final Hrv msg);

}
