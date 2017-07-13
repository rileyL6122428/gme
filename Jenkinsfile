node() {
  stage("HELLO WORLD") {
    sh 'echo hello world'
    withMaven(maven: "JENKINS_MAVEN") {
      sh 'javac -version'
      sh 'java -version'
      sh 'mvn -version'
      sh 'mvn clean install'
    }
  }
}
