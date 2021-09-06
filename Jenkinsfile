def gv
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
        stage ("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("Code Checkout"){
            steps {
                git 'https://github.com/judedotcom/hello-world.git'
            }
        }
        stage("Build") {
            steps {
                // echo "Building the application"
                // echo "Building the version ${NEW_VERSION}"
                // sh "mvn clean package"

                script {
                    gv.buildApp()              
                }
            }
        }
        
        stage("Test") {
            when {
                expression {
                    params.executeTest == true
                }
            }
            steps {
                // echo "Testing the application"
                script {
                    gv.testApp()              
                }

            }
        }
        
        stage("Deploy") {
            steps {
                // echo "Deploying the code"
                // echo "deploying the code ${params.VERSION}"
                script {
                    gv.deployApp()              
                }

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
