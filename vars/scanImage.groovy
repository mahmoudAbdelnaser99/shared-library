def call(String imageName) {
    sh '''
        if ! command -v trivy &> /dev/null; then
            echo "Installing Trivy..."
            sudo apt-get update && sudo apt-get install -y wget apt-transport-https gnupg lsb-release
            wget -qO - https://aquasecurity.github.io/trivy-repo/deb/public.key | sudo apt-key add -
            echo "deb https://aquasecurity.github.io/trivy-repo/deb $(lsb_release -sc) main" | sudo tee /etc/apt/sources.list.d/trivy.list
            sudo apt-get update && sudo apt-get install -y trivy
        fi
    '''
    sh "trivy image ${imageName} || true"
}
