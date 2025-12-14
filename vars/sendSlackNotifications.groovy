def call(String buildStatus = 'STARTED') {

    buildStatus = buildStatus ?: 'SUCCESS'

    def colorCode = '#FF0000'
    if (buildStatus == 'STARTED') {
        colorCode = '#FFFF00'
    } else if (buildStatus == 'SUCCESS') {
        colorCode = '#00FF00'
    }

    slackSend(
        color: colorCode,
        message: "${buildStatus}: Job ${env.JOB_NAME} #${env.BUILD_NUMBER}\n${env.BUILD_URL}"
    )
}
