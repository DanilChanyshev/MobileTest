node('maven') {

    currentBuild.description = "<p style='color: blue;'>Android emulator</p>"

    stage('Checkout') {
        checkout scm
    }

    stage('Start emulator') {
        dir("${env.WORKSPACE}") {
            catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                sh '''
                docker compose up -d
                sleep 60
            '''
            }
        }
    }
}
