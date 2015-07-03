package bo.ihm.beans;

import org.hibernate.validator.constraints.NotEmpty;

@NumeroSecuriteSociale
public class Pojo {

    private boolean forain;
    private String cleSecuriteSociale;
    private String numeroSecuriteSociale;

    @NotEmpty(groups = Mandatory.class)
    private String mandatory;

    public String getCleSecuriteSociale() {
        return cleSecuriteSociale;
    }

    public String getMandatory() {
        return mandatory;
    }

    public String getNumeroSecuriteSociale() {
        return numeroSecuriteSociale;
    }

    public boolean isForain() {
        return forain;
    }

    public void setCleSecuriteSociale(final String pCleSecuriteSociale) {
        cleSecuriteSociale = pCleSecuriteSociale;
    }

    public void setForain(final boolean pForain) {
        forain = pForain;
    }

    public void setMandatory(final String pMandatory) {
        mandatory = pMandatory;
    }

    public void setNumeroSecuriteSociale(final String pNumeroSecuriteSociale) {
        numeroSecuriteSociale = pNumeroSecuriteSociale;
    }
}
