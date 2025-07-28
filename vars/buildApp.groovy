def call(String contextDir, String imageTag) {
    sh "docker build -t ${imageTag} ${contextDir}"
}