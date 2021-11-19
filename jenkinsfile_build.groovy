pipeline{
    agent any
    stages{
        stage("checkout code"){
            steps{
                println "clone our code to our repository"
                sh "ls -l"
                //checkout([$class: 'GitSCM', branches: [[name: '*/branchname']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[ url: 'https://github.com/sivalakshmanna/boxfuse-sample-java-war-hello.git']]])
                //sh "ls -lart ./*"

            }
        }
        stage("build code"){
            steps{
                println "mvn clean package"
                sh "mvn clean package"
                sh "ls -l target/"
            }
        }
        stage("upload artifacts to s3"){
            steps{
                println "uploading artifacts to s3 bucket"
            }
        }
    }
}