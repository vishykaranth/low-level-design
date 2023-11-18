package ridesharing.exception;

public class RiderNotFoundException extends RuntimeException {
  public RiderNotFoundException(final String message) {
    super(message);
  }
}
