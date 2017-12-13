package javamodularity.easytext.analysis.algorithm.kincaid;

import java.util.List;
import javamodularity.easytext.analysis.api.Analyzer;

public class KincaidAnalyzer implements Analyzer {
  public String getName() {
    return "KincaidAnalyzer";
  }

  public double analyze(List<List<String>> text) {
    return 1.2d;
  }
}
