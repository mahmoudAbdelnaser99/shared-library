def call(String imageName, String dockerRepo, String credentialsId) {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh """
            echo "$PASS" | docker login -u "$USER" --password-stdin
            docker tag ${imageName} ${dockerRepo}
            docker push ${dockerRepo}
        """
    }
}