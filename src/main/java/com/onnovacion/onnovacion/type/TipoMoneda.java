package com.onnovacion.onnovacion.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.onnovacion.onnovacion.exception.InvalidEnumValueException;

@JsonFormat(
        shape = JsonFormat.Shape.STRING
)
public enum TipoMoneda {

    PESO_COLOMBIANO,
    DOLAR,
    EURO;

    private TipoMoneda() {
    }

    @JsonValue
    public String getValue() {
        return this.name();
    }

    @JsonCreator
    public static TipoMoneda fromValue(String value) {
        if (value != null && value.isEmpty()) {
            return null;
        }
        else {
            TipoMoneda[] var1 = values();
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                TipoMoneda p = var1[var3];
                if (p.name().equals(value)) {
                    return p;
                }
            }

            throw new InvalidEnumValueException("TipoMoneda", value);
        }
    }
}
