References

https://spring.io/blog/2018/03/06/using-spring-security-5-to-integrate-with-oauth-2-secured-services-such-as-facebook-and-github


This project is a oauth2 client that does the following:
1. Get the code from authentication server(third party like Github and Google)
2. Get accessToken using the code from the previous step


String clientId = "";
String clientSecret = "";

ResponseEntity<AccessTokenDTO> response = restTemplate.exchange(new URI("https://github.com/login/oauth/access_token?client_id="+clientId+"&client_secret="+clientSecret+"&code=" + code), HttpMethod.POST, null,AccessTokenDTO.class);

AccessTokenDTO accessToken = response.getBody();

3. Get user profile using the accessToken from the previous step

GithubUser githubUser = restTemplate.getForObject("https://api.github.com/user", GithubUser.class);

TODO
4. Now that user is authenticated with a third party, use that info to sign up or sign in
5. Generate auth token for the user and pass it back to front end. Front end can then use this auth token for subsequent requests to your apis.
