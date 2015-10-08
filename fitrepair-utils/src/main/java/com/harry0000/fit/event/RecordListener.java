package com.harry0000.fit.event;

import com.harry0000.fit.message.DefinitionMessage;
import com.harry0000.fit.message.Record;

@FunctionalInterface
public interface RecordListener {

    void onMessage(final DefinitionMessage defMsg, final Record msg);

}
