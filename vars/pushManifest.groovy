def call(String email, String username, String credentialsId, String repoName, String buildNumber) {
    withCredentials([string(credentialsId: credentialsId, variable: 'GITHUB_TOKEN')]) {
        sh """
            git config --global user.email "${email}"
            git config --global user.name "${username}"
            git remote set-url origin https://${GITHUB_TOKEN}@github.com/${username}/${repoName}.git
            git add k8s-manifests/deployment.yaml
            git commit -m "Update image tag to build ${buildNumber}" || echo "No changes to commit"
            git push origin main
        """
    }
}
