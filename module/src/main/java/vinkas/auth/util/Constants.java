package vinkas.auth.util;

/**
 * Created by Vinoth on 28-12-15.
 */
public final class Constants {

    public static final String KEY_AUTH_TOKEN_TYPE = "AUTH_TOKEN_TYPE";
    public static final String KEY_IS_NEW_ACCOUNT  = "IS_NEW_ACCOUNT";

    public static final class Access {

        private Access() { }

        public static final String AUTH_TOKEN_TYPE_READ_ONLY = "Read Only";
        public static final String AUTH_TOKEN_TYPE_READ_ONLY_LABEL = "Read only access to DD account";

        public static final String AUTH_TOKEN_FULL_ACCESS = "Full Access";
        public static final String AUTH_TOKEN_FULL_ACCESS_LABEL = "Full access to DD account";
    }

}
