package net.sf.dynamicreports.jasper.base;

import static net.sf.dynamicreports.jasper.base.JasperScriptletManager.USE_THREAD_SAFE_SCRIPLET_MANAGER_PROPERTY_KEY;

import java.util.Properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * Unit tests for {@link JasperCustomValues}.
 */
public class JasperCustomValuesTest {

  private final JasperScriptlet scriptlet = new JasperScriptlet();

  @Test
  public void shouldUseDefaultScriptletManager() {
    final JasperCustomValues cut = createClassUnderTest(false);
    Assertions.assertTrue(cut.getScriptletManager() instanceof DefaultJasperScriptletManager);
  }

  @Test
  public void shouldUseThreadSafeScriptleManagerIfPropertySet() {
    final JasperCustomValues cut = createClassUnderTest(true);
    Assertions.assertTrue(cut.getScriptletManager() instanceof ThreadSafeJasperScriptletManager);
  }

  @Test
  public void shouldSetScriptletWithDefaultManager() {
    final JasperCustomValues cut = createClassUnderTest(false);
    cut.setJasperScriptlet(scriptlet);
    Assertions.assertEquals(scriptlet, cut.getJasperScriptlet());
  }

  @Test
  public void shouldSetScriptletWithThreadSafeManager() {
    final JasperCustomValues cut = createClassUnderTest(true);
    cut.setJasperScriptlet(scriptlet);
    Assertions.assertEquals(scriptlet, cut.getJasperScriptlet());
  }

  private JasperCustomValues createClassUnderTest(boolean useThreadSafeManager) {
    final Properties properties = new Properties();
    if (useThreadSafeManager) {
      properties.setProperty(USE_THREAD_SAFE_SCRIPLET_MANAGER_PROPERTY_KEY, "true");
    }
    return new JasperCustomValues(properties);
  }
}
