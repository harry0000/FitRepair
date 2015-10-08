package com.harry0000.fit.event;

import com.harry0000.fit.message.DefinitionMessage;
import com.harry0000.fit.message.DeviceSettings;

@FunctionalInterface
public interface DeviceSettingsListener {

    void onMessage(final DefinitionMessage defMsg, final DeviceSettings msg);

}
