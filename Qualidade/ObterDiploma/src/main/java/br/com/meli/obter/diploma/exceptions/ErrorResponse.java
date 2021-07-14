package br.com.meli.obter.diploma.exceptions;

import java.util.List;


public class ErrorResponse
{
    //General error message about nature of error
    private final String message;

    //Specific errors in API request processing
    private final List<String> details;

    public ErrorResponse(String message, List<String> details) {
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "message='" + message + '\'' +
                ", details=" + details +
                '}';
    }
}
