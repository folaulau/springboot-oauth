/*======== Add clients =========*/


INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information) VALUES ('springboot', '$2a$10$e3WmQ0YKi590OTTyuaAJLOqJ73i0CWuAXG.cIA.oWLIto4v509Pde', 'http://localhost:7575/code', 'READ,WRITE', '3600', '10000', 'inventory,payment', 'authorization_code,password,refresh_token,implicit', '{}');