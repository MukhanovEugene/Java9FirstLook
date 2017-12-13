package javamodularity.easytext.analysis.algorithm.coleman;

import java.util.List;
import javamodularity.easytext.analysis.api.Analyzer;

public class ColemanAnalyzer implements Analyzer {
  public String getName() {
    return "ColemanAnalyzer";
  }

  public double analyze(List<List<String>> text) {
    return 0.9d;
  }
}
