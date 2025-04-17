pipeline{
    agent any

    stage("Checkout"){

    steps {

    git branch: 'main', credentialsId: 'git-tahyd-token',
     url: 'https://github.com/tahyd/k8s.git'
    }
    }
}