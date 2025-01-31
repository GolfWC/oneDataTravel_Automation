pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'Maven'
        JAVA_HOME = tool 'JDK'

    }


    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                git 'https://github.com/GolfWC/oneDataTravel_Automation.git'
            }
        }

        stage('Build') {
            steps {
                // Build the project using Maven
                sh "${MAVEN_HOME}/bin/mvn clean install"
            }
        }

        stage('Test') {
            steps {
                // Run the tests
                sh "${MAVEN_HOME}/bin/mvn test"
            }


        }

        stage('Post Actions') {
            steps {
                // Archive the test results
                junit '**/target/surefire-reports/*.xml'
                // Archive the screenshots
                archiveArtifacts artifacts: 'screenshots/*.png', allowEmptyArchive: true
            }

        }
    }


    post {
        always {
            // Clean up workspace
            cleanWs()
        }
    }
}