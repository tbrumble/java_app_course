package Tests.homework2;

import homework2.ScannerAnalyzer;
import junit.framework.TestCase;

public class ScannerAnalyzerTest extends TestCase {
    public void testCheckForErrors() {
        assertEquals(new ScannerAnalyzer().checkForErrors("").toString(), "Ошибка ввода, введите число и операцию");
        assertEquals(new ScannerAnalyzer().checkForErrors("1)1").toString(), "Неподдерживаемая операция");
        assertEquals(new ScannerAnalyzer().checkForErrors("1)1").isError(), true);
        assertEquals(new ScannerAnalyzer().checkForErrors("").isError(), true);
    }
}