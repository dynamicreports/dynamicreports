package net.sf.dynamicreports.jasper.base;

import static net.sf.dynamicreports.jasper.base.JasperScriptletManager.USE_THREAD_SAFE_SCRIPLET_MANAGER_PROPERTY_KEY;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link JasperCustomValues}.
 */
public class JasperCustomValuesTest {

  private JasperScriptlet scriptlet = new JasperScriptlet();
  
  @Test
  public void shouldUseDefaultScriptletManager() {
    JasperCustomValues cut = createClassUnderTest(false);
    Assert.assertTrue(cut.getScriptletManager() instanceof DefaultJasperScriptletManager);
  }
  
  @Test
  public void shouldUseThreadSafeScriptleManagerIfPropertySet() {
    JasperCustomValues cut = createClassUnderTest(true);
    Assert.assertTrue(cut.getScriptletManager() instanceof ThreadSafeJasperScriptletManager);
  }

  @Test
  public void shouldSetScriptletWithDefaultManager() {
    JasperCustomValues cut = createClassUnderTest(false);
    cut.setJasperScriptlet(scriptlet);
    Assert.assertEquals(scriptlet, cut.getJasperScriptlet());
  }
  
  @Test
  public void shouldSetScriptletWithThreadSafeManager() {
    JasperCustomValues cut = createClassUnderTest(true);
    cut.setJasperScriptlet(scriptlet);
    Assert.assertEquals(scriptlet, cut.getJasperScriptlet());    
  }
  
  private JasperCustomValues createClassUnderTest(boolean useThreadSafeManager) {
    Properties properties = new Properties();
    if (useThreadSafeManager) {
      properties.setProperty(USE_THREAD_SAFE_SCRIPLET_MANAGER_PROPERTY_KEY, "true");
    }
    return new JasperCustomValues(properties);
  }
}
