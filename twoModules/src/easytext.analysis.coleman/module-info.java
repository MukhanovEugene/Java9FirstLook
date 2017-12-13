module easytext.analysis.coleman {
  requires easytext.analysis;

  provides javamodularity.easytext.analysis.api.Analyzer
    with javamodularity.easytext.analysis.algorithm.coleman.ColemanAnalyzer;
}
