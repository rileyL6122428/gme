node() {
  stage("HELLO WORLD") {
    sh 'echo hello world'
    withMaven(maven: "RILEY_MAVEN") {
      sh 'javac -version'
      sh 'java -version'
      sh 'mvn -version'
      sh 'mvn clean install'
    }
  }
}
