def buildApp() {
    echo "Building the application"
    echo "Building the version ${env.NEW_VERSION}"

}

def testApp() {
    echo 'Testing the application..'
}

def deployApp() {
    echo "Deploying the code"
    echo "deploying the code ${params.VERSION}"    
}