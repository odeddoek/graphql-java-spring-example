package graphql;


import graphql.annotations.GraphQLDataFetcher;
import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLType;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.util.ArrayList;
import java.util.List;

@GraphQLType
public class User {
    public static class TestFetcher implements DataFetcher {

        @Override
        public List<Story> get(DataFetchingEnvironment environment) {
            User parent = (User) environment.getSource();
            Story firstStory = new Story("Oded Story", parent);
            Story secondStory = new Story("Good Story", parent);
            List<Story> stories = new ArrayList<Story>() {{ add(firstStory); add(secondStory);}};
            return stories;
        }
    }

    @GraphQLField
    public String name() {
        return this.getName();
    }

    @GraphQLField
    @GraphQLDataFetcher(TestFetcher.class)
    public List<Story> stories;



    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
