package bo.ihm.beans;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumeroSecuriteSocialeValidator implements ConstraintValidator<NumeroSecuriteSociale, Pojo> {
    public static final Pattern PATTERN_REGEX_NUMERIQUE = Pattern.compile("^[0-9]*$");

    /**
     * Pattern regex permettant de valider le bloc de naissance dans un numéro de sécurité social.
     */
    public final static Pattern PATTERN_REGEX_NUMERO_SECU_BLOC_NAISSANCE = Pattern
        .compile("^([1728]{1})([0-9]{2})(([0][1-9])|([1][0-2])|([2][0])|([5][0]))$");

    /**
     * Pattern regex permettant de valider le boc du département dans un numéro de sécurité social.
     */
    public final static Pattern PATTERN_REGEX_NUMERO_SECU_BLOC_DEPARTEMENT = Pattern.compile("^([0]{1}[1-9]{1})|([1]{1}[0-9]{1})|" + // verification
            // limitée entre 01-19
            "([2]{1}[AB]{1})|([2]{1}[0-1]{1})|"
            + // verification specifique pour la Corse + 21
            "([2]{1}[2-9])|([3-8]{1}[0-9]{1})|"
            + // verification limitée entre 22-89
            "([9]{1}[0-8]{1})|"
            + // verification limitée entre 90-98
            "([9]{1}[9]{1})$"); // verification pour DOM TOM (99)

    @Override
    public void initialize(final NumeroSecuriteSociale constraintAnnotation) {
    }

    @Override
    public boolean isValid(final Pojo formalite, final ConstraintValidatorContext context) {
        if (formalite == null) {
            return false;
        }
        String numero = formalite.getNumeroSecuriteSociale();
        final String cle = formalite.getCleSecuriteSociale();
        if (numero == null || cle == null) {
            return true;
        }

        if (numero.length() != 13 || cle.length() != 2) {
            return false;
        }

        if ("0000000000000".equals(numero) && "00".equals(cle)) {
            return true;
        }

        // decoupage du numero
        final String morceauNaissance = numero.substring(0, 5);
        final String morceauDepartement = numero.substring(5, 7);
        final String morceauInsee = numero.substring(7);

        // morceau Naissance
        if (!PATTERN_REGEX_NUMERO_SECU_BLOC_NAISSANCE.matcher(morceauNaissance).matches()) {
            return false;
        }

        // morceau departement
        if (!PATTERN_REGEX_NUMERO_SECU_BLOC_DEPARTEMENT.matcher(morceauDepartement).matches()) {
            return false;
        }

        // morceau INSEE
        if (!PATTERN_REGEX_NUMERIQUE.matcher(morceauInsee).matches()) {
            return false;
        }

        // TRANSTYPAGE:
        try {
            numero = numero.replaceAll("A", "0").replaceAll("B", "0");

            final long cleChiffre = Long.parseLong(cle);
            final long numeroSecuChiffre = Long.parseLong(numero);

            // CALCUL:
            final long resultatModulo = 97 - numeroSecuChiffre % 97;
            if (resultatModulo == cleChiffre) {
                return true;
            } else {
                return false;
            }
        } catch (final Exception ex) {
            return false;
        }
    }
}
