node() {
  stage("HELLO WORLD") {
    sh 'echo hello world'

    mvn_home = tool 'RILEY_MAVEN'
    sh "echo ${mvn_home}"
    sh "'${mvn_home}/bin/mvn' clean install "
  }
}
