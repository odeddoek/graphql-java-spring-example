package hello;

import graphql.GraphQL;
import graphql.Query;
import graphql.annotations.GraphQLAnnotations;
import graphql.schema.GraphQLObjectType;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static graphql.schema.GraphQLSchema.newSchema;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class GraphQLController {

    @RequestMapping(value = "/graphql", method = RequestMethod.POST)
    public Object graphql(@RequestBody String input) throws IllegalAccessException, NoSuchMethodException, InstantiationException {
        String queryString = getQueryString(input);
        GraphQL graphql = createGraphQLSchema();
        Object returnData = serveQuery(queryString, graphql);

        return returnData;
    }

    private static Object serveQuery(String queryString, GraphQL graphql) {
        Object returnData;

        if (!isIntrospectionQuery(queryString)) {
            returnData = graphql.execute(queryString).getData();
        } else {
            Map<String, Object> result = new HashMap<>();
            result.put("data", graphql.execute(queryString).getData());
            returnData = result;
        }
        return returnData;
    }

    private static GraphQL createGraphQLSchema() throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        GraphQLObjectType queryObject = GraphQLAnnotations.object(Query.class);

        return new GraphQL(newSchema().query(queryObject).build());
    }

    private static String getQueryString(String input) {
        JSONObject requestQuery = new JSONObject(input);
        return requestQuery.getString("query");
    }

    private static boolean isIntrospectionQuery(String queryString) {
        return queryString.contains("IntrospectionQuery");
    }
}
