package bo.ihm.beans;

import java.io.Serializable;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

@ViewScoped
@ManagedBean(name = "testBean")
public class TestBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Valid
    private Pojo pojo;

    public String enregistrerEtat(final String etat) {
        if ("3".equals(etat)) {

            final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            final Set<ConstraintViolation<Pojo>> violations = validator.validate(pojo, Mandatory.class);

            final FacesContext context = FacesContext.getCurrentInstance();
            if (violations.size() > 0) {
                for (final ConstraintViolation<Pojo> violation : violations) {
                    context.addMessage("formaliteACCRE", new FacesMessage(violation.getMessage()));
                }
            }
        }

        return null;
    }

    public Pojo getPojo() {
        return pojo;
    }

    public void init() {
        pojo = new Pojo();
    }

    public void setPojo(final Pojo pPojo) {
        this.pojo = pPojo;
    }
}
