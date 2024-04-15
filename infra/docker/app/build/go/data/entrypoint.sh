#!/bin/sh

cd /home/astarion

# Git clone
git init
git remote add origin https://github.com/redundant4u/astarion.git
git sparse-checkout set server/$DOMAIN
git pull origin $BRANCH

cd server/$DOMAIN

go build main.go
