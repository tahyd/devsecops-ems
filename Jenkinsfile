pipeline{
    agent any

    stage("Checkout"){

    steps {

    git branch: 'main', credentialsId: 'git-tahyd-token',
     url: 'https://github.com/tahyd/devsecops-ems.git'
    }
    }
}