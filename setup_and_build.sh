#!/usr/bin/env bash
set -euo pipefail
PROJECT_DIR="$(pwd)"
APP_RES_RAW="$PROJECT_DIR/app/src/main/res/raw"
APP_DIR="$PROJECT_DIR/app"
GS_PATH="${GS_PATH:-$PROJECT_DIR/google-services.json}"
LOTTIE_PATH="${LOTTIE_PATH:-$PROJECT_DIR/lottie.json}"
KEYSTORE_PATH="${KEYSTORE_PATH:-$PROJECT_DIR/release-keystore.jks}"
echo "Project dir: $PROJECT_DIR"
if [ -f "$GS_PATH" ]; then
  echo "Copying google-services.json -> app/"
  cp "$GS_PATH" "$APP_DIR/google-services.json"
else
  echo "No google-services.json found at $GS_PATH (skip)."
fi
mkdir -p "$APP_RES_RAW"
if [ -f "$LOTTIE_PATH" ]; then
  echo "Copying Lottie JSON -> $APP_RES_RAW/animation.json"
  cp "$LOTTIE_PATH" "$APP_RES_RAW/animation.json"
else
  echo "No lottie.json found at $LOTTIE_PATH (skip)."
fi
if [ -f "$KEYSTORE_PATH" ]; then
  echo "Encoding keystore to base64..."
  if command -v base64 >/dev/null 2>&1; then
    base64 --wrap=0 "$KEYSTORE_PATH" > "$PROJECT_DIR/keystore.b64"
    echo "Wrote keystore.b64"
  else
    echo "base64 not found; cannot encode keystore automatically."
  fi
else
  echo "No release-keystore.jks found (skip)."
fi
read -p "Attempt local Gradle build now? [y/N] " -r
if [[ $REPLY =~ ^[Yy]$ ]]; then
  if [ -f "./gradlew" ]; then
    chmod +x ./gradlew
    ./gradlew :app:assembleDebug --no-daemon
    echo "APK at app/build/outputs/apk/debug/app-debug.apk"
  else
    echo "gradlew not found."
  fi
else
  echo "Skipping local build."
fi
