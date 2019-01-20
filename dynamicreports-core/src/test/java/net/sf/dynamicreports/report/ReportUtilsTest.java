package net.sf.dynamicreports.report;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link ReportUtils}.
 */
public class ReportUtilsTest {

  private static final String BASE_NAME = "any name";
  private static final int NUMBER_OF_THREADS = 20;
  private static final int NUMBER_OF_NAMES = 1000;
  
  @Test
  public void shouldGenerateUniqueNamesConcurrently() throws Exception {
    ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);    
    try {
      List<Future<String>> futureNames = submitTasks(executor);
      assertUniqueNames(futureNames);
    } finally {
      executor.shutdown();
    }
  }
  
  private List<Future<String>> submitTasks(ExecutorService executor) {
    Callable<String> task = () -> ReportUtils.generateUniqueName(BASE_NAME);
    List<Future<String>> futureNames = new ArrayList<>();
    IntStream.range(0, NUMBER_OF_NAMES).forEach(i -> futureNames.add(executor.submit(task)));
    return futureNames;
  }
  
  private void assertUniqueNames(List<Future<String>> futureNames) throws Exception {
    Set<String> generatedNames = new HashSet<>();
    for (Future<String> futureName : futureNames) {
      generatedNames.add(futureName.get());
    }
    Assert.assertEquals(NUMBER_OF_NAMES, generatedNames.size());    
  }
}
