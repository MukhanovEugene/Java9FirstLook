module easytext.analysis.kincaid {
  requires easytext.analysis;

  provides javamodularity.easytext.analysis.api.Analyzer
    with javamodularity.easytext.analysis.algorithm.kincaid.KincaidAnalyzer;
}
