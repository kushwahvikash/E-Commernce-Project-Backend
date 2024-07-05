package com.vikas.ema.gen;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CustomEmployeeIdGenerator implements IdentifierGenerator {

    private static final String PREFIX = "EMP";

    private static int counter = 0;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        return PREFIX + (++counter);
    }
}
