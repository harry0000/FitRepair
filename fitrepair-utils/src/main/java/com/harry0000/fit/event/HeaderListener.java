package com.harry0000.fit.event;

import com.harry0000.fit.Header;

@FunctionalInterface
public interface HeaderListener {

    void onHeader(final Header header);

}
