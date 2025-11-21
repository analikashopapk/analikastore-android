Gradle Wrapper files (partial) for Gradle 8.2

NOTE: gradle-wrapper.jar (binary) is NOT included. You must generate it locally with:
  gradle wrapper --gradle-version 8.2
or copy gradle-wrapper.jar into gradle/wrapper/ from an existing project.

After that:
  chmod +x gradlew
  git add gradlew gradlew.bat gradle/wrapper/*
  git commit -m "Add gradle wrapper"
  git push

CI tips:
  - If you want to use the wrapper in CI, ensure gradle-wrapper.jar is committed.
  - Alternatively, use gradle/gradle-build-action@v2 in your workflow and remove steps that call ./gradlew.
