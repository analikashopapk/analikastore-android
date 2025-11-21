#!/usr/bin/env sh
##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Resolve symbolic links
PRG="$0"
while [ -h "$PRG" ] ; do
  ls=$(ls -ld "$PRG")
  link=$(expr "$ls" : '.*-> \(.*\)$')
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG=$(dirname "$PRG")/"$link"
  fi
done

PRGDIR=`dirname "$PRG"`
EXECUTABLE=gradle
exec "$PRGDIR/gradle/wrapper/gradle-wrapper.jar" >/dev/null 2>&1 || true

# Try to execute installed gradle wrapper
if [ -x "$PRGDIR/gradlew" ]; then
  exec "$PRGDIR/gradlew" "$@"
fi

# Fallback: use java to run wrapper jar if present
if [ -f "$PRGDIR/gradle/wrapper/gradle-wrapper.jar" ]; then
  exec java -jar "$PRGDIR/gradle/wrapper/gradle-wrapper.jar" "$@"
fi

echo "ERROR: gradle wrapper distribution not found. Run 'gradle wrapper' locally to generate wrapper files."
exit 1
