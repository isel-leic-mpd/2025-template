package pt.isel.mpd.spreadsheet1.exceptions;

public class DivByZeroException extends ParserException {
    public DivByZeroException() {
        super("Divison by Zero!");
    }
}
