FROM golang:1.22-alpine

ENV GIN_MODE release
WORKDIR /home/astarion

RUN apk update && apk add git

COPY data/entrypoint.sh /entrypoint.sh

ENTRYPOINT [ "/entrypoint.sh" ]
