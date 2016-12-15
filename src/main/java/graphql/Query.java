package graphql;

import graphql.annotations.GraphQLField;

/**
 * Created by Walla on 15/12/2016.
 */
public class Query {
    @GraphQLField
    public static User defaultUser() {
        User user = new User();
        user.setName("Test Name");
        return user;
    }
}
