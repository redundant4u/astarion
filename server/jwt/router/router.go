package router

import (
	"github.com/gin-gonic/gin"
	"github.com/redundant4u/astarion/server/jwt/handler"
)

func Init(r *gin.Engine) {
	r.GET("/", handler.Auth)
}
