node {

    checkout scm

    env.DOCKER_API_VERSION="1.23"

    sh "git rev-parse --short HEAD > commit-id"

    tag = readFile('commit-id').replace("\n", "").replace("\r", "")
    appName = "jayasekara84/employee-service"
    registryHost = "https://hub.docker.com/"
    imageName = "${registryHost}${appName}:${tag}"
    env.BUILDIMG=imageName

    sh "./gradlew clean build"

    stage "Build"

        sh "docker build  -t jayasekara84/employee-service ."

    stage "Push"

                withDockerRegistry([ credentialsId: "3c1243cf-f0a2-4837-b695-807cf19571d8", url: "" ]) {
                  sh "docker push jayasekara84/employee-service:latest"
                }



    stage "Deploy"

        sh "kubectl create -f deployment.yaml"

}