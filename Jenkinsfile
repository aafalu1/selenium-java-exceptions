pipeline{
agent any
environment{
JAVA_HOME = 'C:\\java_jdk'
MAVEN_HOME = 'C:\\apache\\apache-maven-3.9.1'
PATH = "${MAVEN_HOME}\\bin;${JAVA_HOME}\\bin;${env.PATH}"

}
stages{
stage('Checkout'){
steps{
    bat 'echo "downloaidng required resources"'
checkout([$class: 'GitSCM',
                          branches: [[name: '*/master']],
                          userRemoteConfigs: [[url: 'https://github.com/aafalu1/selenium-java-exceptions.git']]])
}

}
stages {
    stage('Check for Chrome processes') {
      steps {
        script {
          // Check if chromedriver.exe process is running
          if (isProcessRunning('chromedriver.exe')) {
            // Kill the chromedriver.exe process
            killProcess('chromedriver.exe')
            println "Killed chromedriver.exe process"
          }

          // Check if chrome.exe process is running
          if (isProcessRunning('chrome.exe')) {
            // Kill the chrome.exe process
            killProcess('chrome.exe')
            println "Killed chrome.exe process"
          }
        }
      }
    }
}
stage('Build'){
steps{
    bat 'echo "Building project"'
    bat 'mvn clean package -DsuiteXmlFile=testNG.xml'
}

}
stage('Test'){
steps{
    bat 'echo "Test "'
    bat 'mvn verify'
}

}

}
}
def isProcessRunning(processName) {
  def processes = "tasklist /FI \"IMAGENAME eq ${processName}\" /NH /FO CSV".execute().text
  return processes.contains(processName)
}

// Function to kill a process
def killProcess(processName) {
  def processes = "taskkill /IM ${processName} /F".execute().text
  return processes.contains("SUCCESS")
}