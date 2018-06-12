node {

    checkout scm

    env.DOCKER_API_VERSION="1.23"

    sh "git rev-parse --short HEAD > commit-id"

    tag = readFile('commit-id').replace("\n", "").replace("\r", "")
    appName = "jayasekara84/employee"
    registryHost = "https://hub.docker.com/"
    imageName = "${registryHost}${appName}:${tag}"
    env.BUILDIMG=imageName

    stage "Build"

        sh "docker build -t ${imageName} -f Dockerfile jayasekara84/employee"

    stage "Push"

        sh "docker push ${imageName}"

    stage "Deploy"

        sh "sed 's#hub.docker.com/jayasekara84/employee:latest#'$BUILDIMG'#' jayasekara84/employee/deployment.yaml | kubectl apply -f -"

}