package ro.botolanvlad.APBDOO.exceptions;

public class PostNotFoundException extends RuntimeException{
    private static final String MESSAGE = "Post with id %s was not found";

    public PostNotFoundException(String id) {
        super(String.format(MESSAGE, id));
    }
}