package com.yourcompany.invoicing.calculators;

import javax.persistence.Query;
import org.openxava.calculators.ICalculator;
import org.openxava.jpa.XPersistence;
import lombok.*;

public class NextNumberForYearCalculator implements ICalculator {

    @Getter
    @Setter
    int year;

    public Object calculate() throws Exception {
        Query query = XPersistence.getManager().createQuery("select max(i.number) from Invoice i where i.year = :year");
        query.setParameter("year", year);
        Integer lastNumber = (Integer) query.getSingleResult();
        return lastNumber == null ? 1 : lastNumber + 1;
    }

}
