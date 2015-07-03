package bo.ihm;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * <pre>
 *  &lt;listener&gt;
 *         &lt;listener-class&gt;fr.bov3.web.ServletContextListenerBoWebapp&lt;/listener-class&gt;
 *  &lt;/listener&gt;
 * </pre>
 * 
 * @author e.leroux
 * 
 */
public class ServletContextListenerBoIHM implements ServletContextListener {

    // à la fermeture de la servlet
    @Override
    public void contextDestroyed(final ServletContextEvent event) {
    }

    @Override
    public void contextInitialized(final ServletContextEvent event) {
        // Nécessaire pour que la variable javax.faces.INTERPRET_EMPTY_STRING_SUBMITTED_VALUES_AS_NULL soit bien interprété par Tomcat
        // http://stackoverflow.com/questions/6304025/work-around-for-faulty-interpret-empty-string-submitted-values-as-null-in-mojarr
        // http://stackoverflow.com/questions/5225013/coerce-to-zero-at-runtime
        System.setProperty("org.apache.el.parser.COERCE_TO_ZERO", "false");
    }
}
