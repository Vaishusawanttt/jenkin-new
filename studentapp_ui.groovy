pipeline {
    agent any

    stages {
        stage('Pull') {
            steps {
                git changelog: false, poll: false, url: 'https://github.com/Vaishusawanttt/studentapp.ui'
                echo 'Yes, Application repository pull is done !'
            }
        }
        stage('Build') {
            steps {
                sh '/opt/apache-maven-3.9.6/bin/mvn clean package'
                echo 'Yes, Application Build is done !'
            }
        }
        stage('Test') {
            steps {
                sh '/opt/apache-maven-3.9.6/bin/mvn sonar:sonar -Dsonar.projectKey=studentapp-ui -Dsonar.host.url=http://52.207.95.27:9000 -Dsonar.login=5a3b6333454730651ceb5682d2ab4566e5e41b2a'
                echo 'Here we are testing '
            }
        }
        stage('Quality Test') {
            steps {
                echo 'Here we are testing the quality'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy Done'
            }
        
        }
    }
}
