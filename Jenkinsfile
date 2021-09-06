pipeline {
    agent any
    environment {
        NEW_VERSION = '1.3.0'
    }
    tools {
        maven 'M2_HOME'
    }
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'Choice of versions to deploy' )
        booleanParam(name: 'executeTest', defaultValue: true, description: 'Does test needs to be executed')
    }
    
    stages {
        stage("Code Checkout"){
            steps {
                git 'https://github.com/judedotcom/hello-world.git'
                // echo "Branch name is ${env.GIT_BRANCH}"
            }
        }
        stage("Build") {
            // when {
            //     expression {
            //         ((env.GIT_BRANCH == 'dev') || (env.GIT_BRANCH = 'master'))
            //     }
            // }
            steps {
                echo "Building the application"
                echo "Building the version ${NEW_VERSION}"
                sh "mvn clean package"
            }
        }
        
        stage("Test") {
            when {
                expression {
                    params.executeTest == true
                }
            }
            steps {
                echo "Testing the application"
            }
        }
        
        stage("Deploy") {
            steps {
                echo "Deploying the code"
                echo "deploying the code ${params.VERSION}"
            }
        }
    }
    
    post {
        always {
            echo "It's executed always"
        }
        
        failure {
            echo "It's executed when failed"
        }
        
        success {
            echo "It's executed when success"
        }
    }
}
