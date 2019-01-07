
package net.sf.dynamicreports.report.builder.style;

import static net.sf.dynamicreports.report.constant.FontName.ARIAL;
import static net.sf.dynamicreports.report.constant.FontName.COURIER_NEW;
import static net.sf.dynamicreports.report.constant.FontName.TIMES_NEW_ROMAN;

import org.junit.Assert;
import org.junit.Test;

/**
 * Integration tests for {@link StyleBuilders}.
 */
public class StyleBuildersTest {

  private StyleBuilders cut = new StyleBuilders();

  @Test
  public void shouldCreateFontBuilderWithArial() {
    FontBuilder fontBuilder = cut.fontArial();
    Assert.assertEquals(ARIAL, fontBuilder.getFont().getFontName());
    Assert.assertFalse(fontBuilder.getFont().getBold());
    Assert.assertFalse(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithArialBold() {
    FontBuilder fontBuilder = cut.fontArialBold();
    Assert.assertEquals(ARIAL, fontBuilder.getFont().getFontName());
    Assert.assertTrue(fontBuilder.getFont().getBold());
    Assert.assertFalse(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithArialBoldItalic() {
    FontBuilder fontBuilder = cut.fontArialBold().italic();
    Assert.assertEquals(ARIAL, fontBuilder.getFont().getFontName());
    Assert.assertTrue(fontBuilder.getFont().getBold());
    Assert.assertTrue(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithTimesNewRoman() {
    FontBuilder fontBuilder = cut.fontTimesNewRoman();
    Assert.assertEquals(TIMES_NEW_ROMAN, fontBuilder.getFont().getFontName());
    Assert.assertFalse(fontBuilder.getFont().getBold());
    Assert.assertFalse(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithTimesNewRomanBold() {
    FontBuilder fontBuilder = cut.fontTimesNewRomanBold();
    Assert.assertEquals(TIMES_NEW_ROMAN, fontBuilder.getFont().getFontName());
    Assert.assertTrue(fontBuilder.getFont().getBold());
    Assert.assertFalse(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithTimesNewRomanBoldItalic() {
    FontBuilder fontBuilder = cut.fontTimesNewRomanBold().italic();
    Assert.assertEquals(TIMES_NEW_ROMAN, fontBuilder.getFont().getFontName());
    Assert.assertTrue(fontBuilder.getFont().getBold());
    Assert.assertTrue(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithCourierNew() {
    FontBuilder fontBuilder = cut.fontCourierNew();
    Assert.assertEquals(COURIER_NEW, fontBuilder.getFont().getFontName());
    Assert.assertFalse(fontBuilder.getFont().getBold());
    Assert.assertFalse(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithCourierNewBold() {
    FontBuilder fontBuilder = cut.fontCourierNewBold();
    Assert.assertEquals(COURIER_NEW, fontBuilder.getFont().getFontName());
    Assert.assertTrue(fontBuilder.getFont().getBold());
    Assert.assertFalse(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithCourierNewBoldItalic() {
    FontBuilder fontBuilder = cut.fontCourierNewBold().italic();
    Assert.assertEquals(COURIER_NEW, fontBuilder.getFont().getFontName());
    Assert.assertTrue(fontBuilder.getFont().getBold());
    Assert.assertTrue(fontBuilder.getFont().getItalic());
  }

}
