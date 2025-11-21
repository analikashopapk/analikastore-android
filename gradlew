# generate wrapper files (choose Gradle version you need, e.g. 8.2)
gradle wrapper --gradle-version 8.2
chmod +x gradlew
git add gradlew gradlew.bat gradle/wrapper/gradle-wrapper.jar gradle/wrapper/gradle-wrapper.properties
git commit -m "Add Gradle wrapper"
git push

