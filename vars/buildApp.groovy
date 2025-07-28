def call(String appPath = './app', String imageName = 'myapp:latest') {
    sh "docker build -t ${imageName} ${appPath}"
}