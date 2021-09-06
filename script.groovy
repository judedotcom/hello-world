def buildApp() {
    echo "Building the application"
    echo "Building the version ${NEW_VERSION}"
    sh "mvn clean package"
}

def testApp() {
    echo 'Testing the application..'
}

def deployApp() {
    echo "Deploying the code"
    echo "deploying the code ${params.VERSION}"    
}