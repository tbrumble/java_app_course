package homework2;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
/**
 * Класс операция
 * Состоит из двух аргументов и типа операции
 */
public class Operation {
    private OperationType operationType;
    private double valueBeforeOperation;
    private double valueAfterOperation;
}
