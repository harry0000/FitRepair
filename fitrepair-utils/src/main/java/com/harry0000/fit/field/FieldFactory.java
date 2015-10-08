package com.harry0000.fit.field;

import java.nio.ByteOrder;

import com.harry0000.fit.vo.BaseType;

public class FieldFactory {

    /**
     * @param fieldDef
     * @return
     */
    public static Field<?> build(final FieldDefinition fieldDef) {
        return build(fieldDef, null, ByteOrder.BIG_ENDIAN);
    }

    /**
     * @param fieldDef
     * @param value
     * @param bo
     * @return
     */
    public static Field<? extends Object> build(final FieldDefinition fieldDef, final byte[] value, final ByteOrder bo) {
        final BaseType baseType = BaseType.get(fieldDef.getBaseType());
        if (baseType == null) {
            return null;
        }

        final Field<?> field;
        switch (baseType) {
        case ENUM:
            field = new EnumField(fieldDef);
            break;
        case SINT8:
            field = new SInt8Field(fieldDef);
            break;
        case UINT8:
            field = new UInt8Field(fieldDef);
            break;
        case SINT16:
            field = new SInt16Field(fieldDef);
            break;
        case UINT16:
            field = new UInt16Field(fieldDef);
            break;
        case SINT32:
            field = new SInt32Field(fieldDef);
            break;
        case UINT32:
            field = new UInt32Field(fieldDef);
            break;
        case STRING:
            field = new StringField(fieldDef);
            break;
        case FLOAT32:
            field = new Float32Field(fieldDef);
            break;
        case FLOAT64:
            field = new Float64Field(fieldDef);
            break;
        case UINT8Z:
            field = new UInt8zField(fieldDef);
            break;
        case UINT16Z:
            field = new UInt16zField(fieldDef);
            break;
        case UINT32Z:
            field = new UInt32zField(fieldDef);
            break;
        case BYTE:
            field = new ByteField(fieldDef);
            break;
        default:
            // unreachable statement
            field = null;
            break;
        }

        if (field != null) {
            field.setValues(value, bo);
        }

        return field;
    }

    private FieldFactory() {}

}
