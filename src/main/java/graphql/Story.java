package graphql;

import graphql.annotations.GraphQLField;

public class Story {
    private String name;
    private User author;

    public Story(String name, User author) {
        this.name = name;
        this.author = author;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @GraphQLField
    public String name() {
        return this.getName();
    }

    @GraphQLField
    public User author() {return this.getAuthor();}
}
