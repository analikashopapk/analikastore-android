# generate wrapper files (choose Gradle version you need, e.g. 8.2)
gradle wrapper --gradle-version 8.2
chmod +x gradlew
git add gradlew gradlew.bat gradle/wrapper/gradle-wrapper.jar gradle/wrapper/gradle-wrapper.properties
git commit -m "Add Gradle wrapper"
git push

# make sure the wrapper exists and is executable
ls -la ./gradlew
# if file exists but not executable:
chmod +x ./gradlew
# run
./gradlew :app:assembleDebug --no-daemon
