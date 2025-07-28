def call(String manifestPath, String newImageTag) {
    sh "sed -i 's|image:.*|image: ${newImageTag}|g' ${manifestPath}"
}
