def CONTAINER_NAME="politiesysteem"
def CONTAINER_TAG="latest"

pipeline {
    agent any

    stages {
        stage('Initialize'){
            def dockerHome = tool 'Docker'
            def mavenHome  = tool 'Maven3'
            env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
        }

        stage('Checkout') {
            checkout scm
        }

        stage('Build'){
            sh "mvn clean install"
        }

        stage('Sonar'){
            try {
                sh "mvn sonar:sonar"
            } catch(error){
                echo "The sonar server could not be reached ${error}"
            }
        }

        /*stage("Image Prune"){
            imagePrune(CONTAINER_NAME)
        }*/

        /*stage('Image Build'){
            imageBuild(CONTAINER_NAME, CONTAINER_TAG)
        }

        stage('Run App'){
            runApp(CONTAINER_NAME, CONTAINER_TAG, DOCKER_HUB_USER, HTTP_PORT)
        }*/

        stage('Docker-compose'){
            try {
                sh "docker-compose up"
            }catch(error){}
        }
    }

}

/*def imagePrune(containerName){
    try {
        sh "docker image prune -f"
        sh "docker stop $containerName"
    } catch(error){}
}

def imageBuild(containerName, tag){
    sh "docker build -t $containerName:$tag -t $containerName --pull --no-cache ."
    echo "Image build complete"
}

def runApp(containerName, tag, dockerHubUser, httpPort){
    sh "docker pull $dockerHubUser/$containerName"
    sh "docker run -d --rm -p $httpPort:$httpPort --name $containerName $dockerHubUser/$containerName:$tag"
    echo "Application started on port: ${httpPort} (http)"
}*/