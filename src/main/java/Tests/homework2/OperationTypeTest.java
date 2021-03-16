package Tests.homework2;

import homework2.OperationType;
import junit.framework.TestCase;

public class OperationTypeTest extends TestCase {

    public void testGetOperationResult() {
        double[] values = new double[] {1.1, 0.6};

        String substraction = String.valueOf(values[0] - values[1]);
        String addition = String.valueOf(values[0] + values[1]);
        String multiplication = String.valueOf(values[0] * values[1]);
        String division = String.valueOf(values[0] / values[1]);

        assertEquals(OperationType.getOperationResult(OperationType.SUBTRACTION, values), substraction);
        assertEquals(OperationType.getOperationResult(OperationType.ADDITION, values), addition);
        assertEquals(OperationType.getOperationResult(OperationType.MULTIPLICATION, values), multiplication);
        assertEquals(OperationType.getOperationResult(OperationType.DIVISION, values), division);
    }

    public void testGetOperationType() {
        assertEquals(OperationType.getOperationType(OperationType.MULTIPLICATION), "\\*");
        assertEquals(OperationType.getOperationType(OperationType.ADDITION), "\\+");
        assertEquals(OperationType.getOperationType(OperationType.DIVISION), "/");
        assertEquals(OperationType.getOperationType(OperationType.SUBTRACTION), "-");
    }

    public void testSearchOperationTypeInText() {
        assertEquals(OperationType.searchOperationTypeInText("+"), OperationType.ADDITION);
        assertEquals(OperationType.searchOperationTypeInText("/"), OperationType.DIVISION);
        assertEquals(OperationType.searchOperationTypeInText("*"), OperationType.MULTIPLICATION);
        assertEquals(OperationType.searchOperationTypeInText("-"), OperationType.SUBTRACTION);
    }
}