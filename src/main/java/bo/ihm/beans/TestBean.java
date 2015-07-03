package bo.ihm.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.Valid;

@ViewScoped
@ManagedBean(name = "testBean")
public class TestBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Valid
    private Pojo pojo;

    public Pojo getPojo() {
        return pojo;
    }

    public void init() {
        pojo = new Pojo();
        pojo.setNumeroSecuriteSociale("2531257351038");
        pojo.setCleSecuriteSociale("22");
    }

    public void setPojo(final Pojo pPojo) {
        this.pojo = pPojo;
    }
}
