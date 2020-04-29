package graphql;

import graphql.annotations.GraphQLAnnotations;
import graphql.schema.GraphQLObjectType;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static graphql.schema.GraphQLSchema.newSchema;

@Component
public class RepositorySchema {

    private Query query;

    private GraphQL graphQL;

    @Autowired
    public RepositorySchema(Query query) throws IllegalAccessException, NoSuchMethodException, InstantiationException {
        this.query = query;
        this.graphQL = createGraphQLSchema();
    }

    public Object execute(String queryString) {
        Object returnData;
        if (!isIntrospectionQuery(queryString)) {
            returnData = graphQL.execute(queryString, query).getData();
        } else {
            returnData = graphQL.execute(queryString).getData();
        }

        Map<String, Object> result = new HashMap<>();
        result.put("data", returnData);
        return result;
    }

    private GraphQL createGraphQLSchema() throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        GraphQLObjectType queryObject = GraphQLAnnotations.object(Query.class);

        return new GraphQL(newSchema().query(queryObject).build());
    }

    private static boolean isIntrospectionQuery(String queryString) {
        return queryString.contains("IntrospectionQuery");
    }
}
