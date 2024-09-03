
package net.sf.dynamicreports.report.builder.style;

import static net.sf.dynamicreports.report.constant.FontName.ARIAL;
import static net.sf.dynamicreports.report.constant.FontName.COURIER_NEW;
import static net.sf.dynamicreports.report.constant.FontName.TIMES_NEW_ROMAN;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * Integration tests for {@link StyleBuilders}.
 */
public class StyleBuildersTest {

  private final StyleBuilders cut = new StyleBuilders();

  @Test
  public void shouldCreateFontBuilderWithArial() {
    final FontBuilder fontBuilder = cut.fontArial();
    Assertions.assertEquals(ARIAL, fontBuilder.getFont().getFontName());
    Assertions.assertFalse(fontBuilder.getFont().getBold());
    Assertions.assertFalse(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithArialBold() {
    final FontBuilder fontBuilder = cut.fontArialBold();
    Assertions.assertEquals(ARIAL, fontBuilder.getFont().getFontName());
    Assertions.assertTrue(fontBuilder.getFont().getBold());
    Assertions.assertFalse(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithArialBoldItalic() {
    final FontBuilder fontBuilder = cut.fontArialBold().italic();
    Assertions.assertEquals(ARIAL, fontBuilder.getFont().getFontName());
    Assertions.assertTrue(fontBuilder.getFont().getBold());
    Assertions.assertTrue(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithTimesNewRoman() {
    final FontBuilder fontBuilder = cut.fontTimesNewRoman();
    Assertions.assertEquals(TIMES_NEW_ROMAN, fontBuilder.getFont().getFontName());
    Assertions.assertFalse(fontBuilder.getFont().getBold());
    Assertions.assertFalse(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithTimesNewRomanBold() {
    final FontBuilder fontBuilder = cut.fontTimesNewRomanBold();
    Assertions.assertEquals(TIMES_NEW_ROMAN, fontBuilder.getFont().getFontName());
    Assertions.assertTrue(fontBuilder.getFont().getBold());
    Assertions.assertFalse(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithTimesNewRomanBoldItalic() {
    final FontBuilder fontBuilder = cut.fontTimesNewRomanBold().italic();
    Assertions.assertEquals(TIMES_NEW_ROMAN, fontBuilder.getFont().getFontName());
    Assertions.assertTrue(fontBuilder.getFont().getBold());
    Assertions.assertTrue(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithCourierNew() {
    final FontBuilder fontBuilder = cut.fontCourierNew();
    Assertions.assertEquals(COURIER_NEW, fontBuilder.getFont().getFontName());
    Assertions.assertFalse(fontBuilder.getFont().getBold());
    Assertions.assertFalse(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithCourierNewBold() {
    final FontBuilder fontBuilder = cut.fontCourierNewBold();
    Assertions.assertEquals(COURIER_NEW, fontBuilder.getFont().getFontName());
    Assertions.assertTrue(fontBuilder.getFont().getBold());
    Assertions.assertFalse(fontBuilder.getFont().getItalic());
  }

  @Test
  public void shouldCreateFontBuilderWithCourierNewBoldItalic() {
    final FontBuilder fontBuilder = cut.fontCourierNewBold().italic();
    Assertions.assertEquals(COURIER_NEW, fontBuilder.getFont().getFontName());
    Assertions.assertTrue(fontBuilder.getFont().getBold());
    Assertions.assertTrue(fontBuilder.getFont().getItalic());
  }

}
