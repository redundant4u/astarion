#!/bin/sh

cd /home/astarion

# Git clone
git init
git remote add origin https://github.com/redundant4u/astarion.git
git sparse-checkout set server/$DOMAIN
git pull origin $BRANCH

cd server/$DOMAIN

# Copy essential files
cp /application.yml src/main/resources/application.yml
cp /internal.jar libs/internal.jar

# Build
gradle build --daemon --build-cache --parallel

java -Djarmode=layertools -jar build/libs/$DOMAIN-$VERSION-SNAPSHOT.jar extract
