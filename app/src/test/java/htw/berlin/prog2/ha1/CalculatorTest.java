package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen

    @Test
    @DisplayName("should be able to display the transponse form of the given number ")
    void testTransponseNumber() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("1/x");

        String expected = "0.5";
        String actual = calc.readScreen();


        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("should display Error when trying to find the inverse of 0")
    void testInverse(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("1/x");

        String expected = "Error"; // weil hier du immer Infinity bekommst, wenn du iwas durch 0 dividierst, in dem <code stand aber nicht das <ding mit dem Infinity, das stand nur bei dem Division. Und jetzt wenn wir anstatt x "0" auswählen, dann dividieren wir quasi auch durch 0 beim 1/x
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }




    @Test
    @DisplayName("should be able to display the result of equals key when no other operation is initiated ")
    void testEqualsKey(){
        Calculator calc = new Calculator();
        calc.pressEqualsKey();
        String expected = "0";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

















}






