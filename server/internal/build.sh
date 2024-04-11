#!/bin/sh

./gradlew build

cp build/libs/*.jar ../member/libs
cp build/libs/*.jar ../auth/libs

../member/gradlew --refresh-dependencies
../auth/gradlew --refresh-dependencies
