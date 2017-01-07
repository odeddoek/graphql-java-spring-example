package endpoints;

import graphql.RepositorySchema;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class GraphQLController {

    @Autowired
    private RepositorySchema repositorySchema;

    @RequestMapping(value = "/graphql", method = RequestMethod.POST)
    public Object graphql(@RequestBody String input) throws IllegalAccessException, NoSuchMethodException, InstantiationException {
        String queryString = getQueryString(input);
        Object execute = repositorySchema.execute(queryString);
        return execute;
    }

    private static String getQueryString(String input) {
        JSONObject requestQuery = new JSONObject(input);
        return requestQuery.getString("query");
    }
}
