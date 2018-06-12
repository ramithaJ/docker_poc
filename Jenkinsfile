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

                withDockerRegistry([ credentialsId: "192a93d0-3361-4327-83c1-1dbf4831e757", url: "" ]) {
                  sh "docker push jayasekara84/employee:latest"
                }



    stage "Deploy"

        sh "sed 'jayasekara84/employee:latest' deployment.yaml | kubectl create -f deployment.yaml"

}