# springboot-oauth

We have a Authorization server in springboot-oauth2-auth-server.

We have a Resource server in springboot-oauth2-resource-server.

I have Postman for testing login(/oauth/token) to Authorization server and getting resources from the Resource server.

## Authorization server
run schema.sql in database before or after starting the springboot-oauth2-auth-server project.

Protocol Flow

1. Authorization request is sent from client to server (acting as resource owner) using password authorization grant
2. Access token is returned to the client (along with refresh token)
3. Access token is then sent from client to server (acting as resource server) on each request for protected resource access
4. Server responds with required protected resources
