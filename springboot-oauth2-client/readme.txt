
Oauth2 Steps
1. Authorize with oauth2 server

https://{oauth2ServerDomain}/login/oauth/authorize?client_id={clientId}&scope={scope}

I used user as scope and github.com as oauth2ServerDomain for testing.

** User is authenticating(signing in) with his/her credentials onto the oauth2 server. In this case, it's Github **

2. Send code to backend
oauth2 server or Github(assuming user logged in successfuly) redirects user to a predefined url(set up in app) with code(code=asdfsdf2342sdfasdf)

https://{redirectUrl}?code=4fe2ca81cf4c4f661663

Front end will send this code to the backend for verification and consuming resources from resource server or Github.

3. Backend gets the code from authentication server(third party like Github and Google)
4. Backend gets accessToken using the code from the previous step


String clientId = "";
String clientSecret = "";

ResponseEntity<AccessTokenDTO> response = restTemplate.exchange(new URI("https://github.com/login/oauth/access_token?client_id="+clientId+"&client_secret="+clientSecret+"&code=" + code), HttpMethod.POST, null,AccessTokenDTO.class);

AccessTokenDTO accessToken = response.getBody();
// accessToken
{
  "scope" : "user",
  "access_token" : "81adb87c4496d193cd6ae75895903774989174c7",
  "token_type" : "bearer"
}

5. Backend gets user profile using the access_token from the previous step

GithubUser githubUser = restTemplate.getForObject("https://api.github.com/user", GithubUser.class);

TODO
6. Now that user is authenticated with a third party, use that info to sign up or sign in
7. Generate auth token for the user and pass it back to front end. Front end can then use this auth token for subsequent requests to your apis.



References
https://spring.io/blog/2018/03/06/using-spring-security-5-to-integrate-with-oauth-2-secured-services-such-as-facebook-and-github




