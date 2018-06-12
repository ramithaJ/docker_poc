node {

    checkout scm

    env.DOCKER_API_VERSION="1.23"

    sh "git rev-parse --short HEAD > commit-id"

    tag = readFile('commit-id').replace("\n", "").replace("\r", "")
    appName = "jayasekara84/employee"
    registryHost = "https://hub.docker.com/"
    imageName = "${registryHost}${appName}:${tag}"
    env.BUILDIMG=imageName

    sh "./gradlew clean build"

    stage "Build"

        sh "docker build  -t jayasekara84/employee ."

    stage "Push"

                withDockerRegistry([ credentialsId: "6544de7e-17a4-4576-9b9b-e86bc1e4f903", url: "" ]) {
                  sh "docker push jayasekara84/employee:latest"
                }



    stage "Deploy"

        sh "sed 's#hub.docker.com/jayasekara84/employee:latest#'$BUILDIMG'#' jayasekara84/employee/deployment.yaml | kubectl apply -f -"

}