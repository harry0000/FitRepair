package com.harry0000.fit;

import static com.harry0000.fit.Constants.BIG_ENDIAN;
import static com.harry0000.fit.Constants.LITTLE_ENDIAN;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.harry0000.fit.field.Field;
import com.harry0000.fit.field.FieldDefinition;
import com.harry0000.fit.message.DataMessage;
import com.harry0000.fit.message.DefinitionMessage;
import com.harry0000.fit.vo.BaseType;

public class Writer {

    /**
     * @param header
     * @param out
     * @throws IOException
     */
    public static void writeHeader(final Header header,
                                   OutputStream out) throws IOException {
        out.write(header.getHeader(), 0, header.getHeaderSize());
    }

    /**
     * @param defMsg
     * @param out
     * @throws IOException
     */
    public static void writeDefinitionMessage(final DefinitionMessage defMsg,
                                              OutputStream out) throws IOException {
        if (defMsg.getNumOfFields() != defMsg.getFields().size()) {
            throw new IllegalArgumentException(
                      "'numOfFields' must be equal to size of field definitions." +
                      " numOfFields: " + defMsg.getNumOfFields() +
                      ", field size: " + defMsg.getFields().size()
                  );
        }

        out.write(defMsg.getHeader());
        out.write(defMsg.getReserved());

        final ByteOrder bo = defMsg.getByteOrder();
        final ByteBuffer bb = ByteBuffer.allocate(2)
                                        .order(bo)
                                        .putShort(defMsg.getFitMessageNumber());
        out.write(bo == ByteOrder.BIG_ENDIAN ? BIG_ENDIAN : LITTLE_ENDIAN);
        out.write(bb.array());

        out.write(defMsg.getNumOfFields());

        for (final FieldDefinition fieldDef : defMsg.getFields()) {
            out.write(fieldDef.getDefinitionNumber());
            out.write(fieldDef.getSize());
            out.write(fieldDef.getBaseType());
        }
    }

    /**
     * @param defMsg
     * @param msg
     * @param out
     * @throws IOException
     */
    public static void writeDataMessage(final DefinitionMessage defMsg,
                                        final DataMessage msg,
                                        OutputStream out) throws IOException {
        if (defMsg.getNumOfFields() != defMsg.getFields().size()) {
            throw new IllegalArgumentException(
                      "'numOfFields' must be equal to size of field definitions." +
                      " numOfFields: " + defMsg.getNumOfFields() +
                      ", field size: " + defMsg.getFields().size()
                  );
        }

        if (defMsg.getNumOfFields() != msg.getFields().size()) {
            throw new FitRuntimeException(
                      "'numOfFields' must be equal to size of data message fields." +
                      " numOfFields: " + defMsg.getNumOfFields() +
                      ", field size: " + msg.getFields().size()
                  );
        }

        final List<Field<?>> fields = new ArrayList<>(defMsg.getFields().size());
        for (final FieldDefinition fieldDef : defMsg.getFields()) {
            final Field<?> field = msg.getField(fieldDef.getDefinitionNumber());
            if (field == null) {
                throw new FitRuntimeException(
                          "Couldn't find the defined field." +
                          " message header: 0x" + Integer.toHexString(msg.getHeader()) +
                          ", definition number: " + fieldDef.getDefinitionNumber()
                      );
            }
            fields.add(field);
        }

        out.write(msg.getHeader());

        final ByteOrder bo = defMsg.getByteOrder();
        for (final Field<?> field : fields) {
            final BaseType baseType = field.getBaseType();
            if (baseType == BaseType.STRING) {
                final byte[] value;
                if (field.isInvalid()) {
                    value = new byte[field.getSize()];
                } else {
                    value = field.toString().getBytes(StandardCharsets.UTF_8);
                }
                out.write(value);
            } else {
                final int elements = field.getSize() / baseType.getSize();
                for (int i = 0; i < elements; i++) {
                    if (field.isInvalid(i)) {
                        out.write(baseType.getInvalidValue(bo));
                        continue;
                    }

                    final ByteBuffer bb = ByteBuffer.allocate(baseType.getSize()).order(bo);
                    final Number n = field.toNumber(i);
                    switch (baseType) {
                    case ENUM:
                    case SINT8:
                    case UINT8:
                    case UINT8Z:
                    case BYTE:
                        bb.put(n.byteValue());
                        out.write(bb.array());
                        break;
                    case SINT16:
                    case UINT16:
                    case UINT16Z:
                        bb.putShort(n.shortValue());
                        out.write(bb.array());
                        break;
                    case SINT32:
                    case UINT32:
                    case UINT32Z:
                        bb.putInt(n.intValue());
                        out.write(bb.array());
                        break;
                    case FLOAT32:
                        bb.putFloat(n.floatValue());
                        out.write(bb.array());
                        break;
                    case FLOAT64:
                        bb.putDouble(n.doubleValue());
                        out.write(bb.array());
                        break;
                    default:
                        // unreachable statement
                        // do nothing
                        break;
                    }
                }
            }
        }
    }

    private Writer() {}

}
