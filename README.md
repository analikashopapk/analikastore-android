# AnalikaStore Android App (Recreated)

This project is a recreated Android Studio project (Kotlin) prepared by assistant.

## What is included
- WebView wrapper for https://www.analikastore.com
- Splash with Lottie placeholder (res/raw/animation.json)
- ProductsActivity with RecyclerView and Coil image loading
- Retrofit skeleton and coroutine dependencies
- Firebase Messaging integrated (MyFirebaseMessagingService)
- TokenUploader to post FCM token to backend (placeholder URL)
- GitHub Actions workflows for debug build and release template
- Setup scripts to copy google-services.json and lottie.json and optionally build locally

## How to use
1. Download and unzip this project.
2. Optionally place `google-services.json` and `lottie.json` next to the project root.
3. Run `./setup_and_build.sh` (macOS/Linux) or `.\setup_and_build.ps1` (Windows).
4. To push to GitHub: initialize git and push to your repo (see earlier chat for exact commands).
