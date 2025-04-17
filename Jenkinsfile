def qualityGateStatus;
pipeline{
    agent any



    environment{
        sonarHome= tool "sonar-scanner"
    }
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven3"
        jdk "jdk21"
    }

stages{
    stage("Checkout"){

    steps {

    git branch: 'main', credentialsId: 'git-tahyd-token',
     url: 'https://github.com/tahyd/devsecops-ems.git'
    }
    }

    stage("Compile"){

     steps {

withSonarQubeEnv("sonarqube"){
                        bat "${sonarHome}/bin/sonar-scanner"
                    }


     }
    }
  stage("Sonar QualityGate"){
                steps {

                    script {
                        def qualityGate = waitForQualityGate();
                        echo "${qualityGate.status}"
                        echo "Hello World!"

                        if(qualityGate.status != "OK"){
                            error "Code quality analysys is failed "

                        }
                        else{
                            qualityGateStatus='OK'
                        }
                    }
                }
            }
stage ("Build Package"){
                when{
                    expression {
                        return qualityGateStatus=='OK'
                    }
                }
                steps{
                   bat 'mvn package'
                    }
                }
stage("build docker image"){

                    steps{
                        bat 'docker build -t sonar-demo .'
                    }
                }



}
}