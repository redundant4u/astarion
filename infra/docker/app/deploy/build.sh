#!/bin/sh

if [ -z "$1" ]; then
    echo "Please type the domain name as the first argument."
    exit 1
fi

directories=("application" "dependencies" "snapshot-dependencies" "spring-boot-loader")
for dir in "${directories[@]}"; do
    rm -r "data/$dir" >> /dev/null 2>&1
done

paths=("application" "dependencies" "snapshot-dependencies" "spring-boot-loader")
for path in "${paths[@]}"; do
    docker cp \
        "astarion-build-$1:/home/astarion/server/$1/$path" "data/$path" || \
        { echo "Failed to copy $path"; exit 1; }
done

docker build -t "astarion:$1" .
