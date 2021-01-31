package com.lovemesomecoding.model;

public interface RoleType {

    /**
     * ROLE_XXX is used for method access validation
     */

    String ROLE_PREFIX     = "ROLE_";

    /**
     * =========== User roles ===============
     */
    String USER            = "USER";

    /**
     * Someone user invited
     */
    String FRIEND          = "FRIEND";

    String ROLE_USER       = ROLE_PREFIX + USER;

    String ROLE_FRIEND     = ROLE_PREFIX + FRIEND;

    /**
     * ============ Employee roles ===========
     */
    String ADMIN           = "ADMIN";

    String ROLE_ADMIN      = ROLE_PREFIX + ADMIN;

    String SUPERVISOR      = "SUPERVISOR";

    String ROLE_SUPERVISOR = ROLE_PREFIX + SUPERVISOR;

}
