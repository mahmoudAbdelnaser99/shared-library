def call(String email, String username, String gitCredId, String repoName, String tag) {
    withCredentials([string(credentialsId: gitCredId, variable: 'GITHUB_TOKEN')]) {
        sh """
            git config --global user.email "${email}"
            git config --global user.name "${username}"
            git remote set-url origin https://${GITHUB_TOKEN}@github.com/${username}/${repoName}.git
            git add k8s-manifests/deployment.yaml
            git commit -m "Update image tag to build ${tag}" || echo "No changes to commit"
            git push origin main
        """
    }
}
