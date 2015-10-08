package com.harry0000.fit.event;

import com.harry0000.fit.message.DefinitionMessage;
import com.harry0000.fit.message.DeviceInfo;

@FunctionalInterface
public interface DeviceInfoListener {

    void onMessage(final DefinitionMessage defMsg, final DeviceInfo msg);

}
