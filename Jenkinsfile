node() {
  stage("HELLO WORLD") {
    sh 'echo hello world'
    withMaven(maven: "JENKINS_MAVEN") {
      sh 'mvn clean install'
  }
}
