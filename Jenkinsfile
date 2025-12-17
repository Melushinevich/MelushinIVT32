pipeline {
    agent any
    
    tools {
        jdk 'JDK-17'
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build and Test') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean test jacocoTestReport'
            }
        }
        
        stage('Publish Test Results') {
            steps {
                junit 'build/test-results/test/*.xml'
            }
        }
        
        stage('Publish Coverage Report') {
            steps {
                script {
                    step([
                        $class: 'JacocoPublisher',
                        execPattern: 'build/jacoco/test.exec',
                        classPattern: 'build/classes/java/main',
                        sourcePattern: 'src/main/java',
                        exclusionPattern: '**/test/**',
                        inclusionPattern: '**/*.class',
                        minimumInstructionCoverage: '0',
                        minimumBranchCoverage: '0',
                        minimumComplexityCoverage: '0',
                        minimumLineCoverage: '0',
                        minimumMethodCoverage: '0',
                        maximumInstructionCoverage: '100',
                        maximumBranchCoverage: '100',
                        maximumComplexityCoverage: '100',
                        maximumLineCoverage: '100',
                        maximumMethodCoverage: '100',
                        changeBuildStatus: false
                    ])
                }
            }
        }
    }
    
    post {
        always {
            archiveArtifacts artifacts: 'build/reports/jacoco/test/html/**/*', fingerprint: true
        }
    }
}
