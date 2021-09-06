// def env = System.getenv()
// def version = env['NEW_VERSION']

def buildApp() {
    echo "Building the application"
    echo "Building the version ${env.NEW_VERSION}"
    sh "mvn clean package"
}

def testApp() {
    echo 'Testing the application..'
}

def deployApp() {
    echo "Deploying the code"
    echo "deploying the code ${params.VERSION}"    
}

return this