package Tests.homework2;

import homework2.OperationExt;
import homework2.OperationType;
import junit.framework.TestCase;

public class OperationExtTest extends TestCase {
    public void testErrorToString(){
        String errorString = "Ошибка";
        OperationExt operationExt = new OperationExt().setError(Boolean.TRUE).setErrorMessage(errorString);
        assertEquals(operationExt.toString(), errorString);
    }

    public void testToString(){
        double[] values = new double[] {1.1, 2};
        OperationExt operationExt = (OperationExt) new OperationExt().setError(Boolean.FALSE).
                setOperationType(OperationType.ADDITION).
                setValueBeforeOperation(values[0]).
                setValueAfterOperation(values[1]);
        String result = String.valueOf(values[0] + values[1]);
        assertEquals(operationExt.toString(), result);
    }
}