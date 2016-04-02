package com.harry0000.fit.message;

import com.harry0000.fit.vo.BaseType;

interface FieldProfile {

    /**
     * @return
     */
    byte getDefinitionNumber();

    /**
     * @return
     */
    BaseType getBaseType();

    /**
     * @return
     * @see BaseType#getInvalid()
     */
    default Number getInvalid() {
        return getBaseType().getInvalid();
    }

}
