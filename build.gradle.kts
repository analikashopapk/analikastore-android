buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // gradle plugin handled by wrapper in real projects
    }
}


buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Google services plugin for Firebase
        classpath("com.google.gms:google-services:4.4.0")
    }
}
