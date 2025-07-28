def call(String manifestPath, String newImage) {
    sh "sed -i 's|image:.*|image: ${newImage}|g' ${manifestPath}"
}
