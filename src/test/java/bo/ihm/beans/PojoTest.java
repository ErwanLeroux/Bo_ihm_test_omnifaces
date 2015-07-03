package bo.ihm.beans;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.junit.Test;

public class PojoTest {
    @Test
    public void testNumeroSecuriteSociale() {
        final Pojo pojo = new Pojo();
        pojo.setNumeroSecuriteSociale("2531257351038");
        pojo.setCleSecuriteSociale("22");

        final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        final Set<ConstraintViolation<Pojo>> violations = validator.validate(pojo, Default.class);

        assertEquals(1, violations.size());
        assertEquals(
            "ConstraintViolationImpl{interpolatedMessage='Pojo [forain=false, cleSecuriteSociale=22, numeroSecuriteSociale=2531257351038, mandatory=null] is not valid', "
                    + "propertyPath=, "
                    + "rootBeanClass=class bo.ihm.beans.Pojo, "
                    + "messageTemplate='${validatedValue} is not valid'}",
            violations.iterator().next().toString());
    }
}
