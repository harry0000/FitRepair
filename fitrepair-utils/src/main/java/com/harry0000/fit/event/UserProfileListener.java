package com.harry0000.fit.event;

import com.harry0000.fit.message.DefinitionMessage;
import com.harry0000.fit.message.UserProfile;

@FunctionalInterface
public interface UserProfileListener {

    void onMessage(final DefinitionMessage defMsg, final UserProfile msg);

}
