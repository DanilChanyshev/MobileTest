node('maven') {

    currentBuild.description = "<p style='color: blue;'>Android emulator</p>"

    stage('Checkout') {
        checkout scm
    }

    stage('Start emulator') {
        dir("${env.WORKSPACE}") {
            sh "docker-compose up -d"
        }
    }
}
