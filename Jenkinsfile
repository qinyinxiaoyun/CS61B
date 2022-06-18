pipeline {
    agent any
    tools {
        mvn "Maven"
    }
    parameters {
        choice(name: 'VERSION', choices: ['1.0', '1.1', 'latest'])
    }
    environment {
        CREDENTIALS = credentials("server-mty")
    }
    stages {
        stage("build") {
            steps {
                docker build -t "qinxinxiaoyun/cs61b_ci:latest" .
            }
        }
        stage("test") {
            steps {
                echo "testing CS61B"
            }
        }
        stage("publish") {
            steps {
                echo "credentials ${CREDENTIALS}"
                withCredentials([
                    usernamePassword(credentials: 'server-mty', usernameVariable: USER, passwordVariable: PWD)
                ]) {
                    echo "username: ${USER}, passwd: ${PWD}"
                }
            }
        }
    }
}
