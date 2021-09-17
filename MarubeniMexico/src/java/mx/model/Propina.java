package mx.model;

import java.math.BigDecimal;

public class Propina {

    private BigDecimal prop;

    public Propina() {
    }

    public Propina(BigDecimal prop) {
        this.prop = prop;
    }

    public BigDecimal getProp() {
        return this.prop;
    }

    public void setProp(BigDecimal prop) {
        this.prop = prop;
    }
 }


