package main

import (
	"log"

	"github.com/gin-gonic/gin"
	"github.com/redundant4u/astarion/server/jwt/router"
)

func main() {
	r := gin.Default()
	router.Init(r)

	log.Println("Server is running on port 8082")

	log.Fatal(r.Run(":8082"))
}
