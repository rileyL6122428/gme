node() {
  stage("HELLO WORLD") {
    sh 'echo hello world'
    sh "echo ${PATH}"
    mvn_home = tool 'RILEY_MAVEN'
    sh "echo ${mvn_home}"
    sh "'${mvn_home}/bin/mvn' clean install "
  }
}
