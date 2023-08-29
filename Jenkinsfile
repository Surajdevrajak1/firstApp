pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
               echo 'Build App'
            }
        }
        
        stage('Test') {
            steps {
                // dir('path/to/your/project')
                // Build your project here
                // For example, using Maven:
                echo 'Test App'
            }
        }
        stage('Deploy') {
            steps {
                // dir('path/to/your/project')
                // Build your project here
                // For example, using Maven:
                echo 'Deploy App'
            }
        }
    }
    
    post {
        always {
            // Clean up or perform any cleanup tasks
            echo "Always executed"
        }
        
        success {
            // Actions to perform on successful checkout and build
            echo "Successful checkout and build"
        }
        
        failure {
            // Actions to perform on checkout or build failure
            echo "Checkout or build failed"
        }
    }
}
