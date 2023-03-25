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
stage('Kill chromedriver.exe') {
    steps {
        script {
            def processName = 'chromedriver.exe'
            def pid = bat(returnStdout: true, script: "tasklist /FI \"IMAGENAME eq $processName\" /NH /FO CSV | findstr /i \"$processName\"")
                .trim()
                .replaceAll('"','')
                .split(',')[1]
            bat 'echo "kill processes for $processName"'
            bat "taskkill /F /PID $pid"
        }
    }
}
}
}
}