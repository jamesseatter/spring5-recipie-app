package eu.seatter.spring5recipeapp.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 12/03/2019
 * Time: 15:10
 */
public class NumberFormatException  extends RuntimeException {
    public NumberFormatException() {
        super();
    }

    public NumberFormatException(String message) {
        super(message);
    }

    public NumberFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
