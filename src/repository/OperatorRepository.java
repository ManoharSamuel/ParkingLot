package repository;

import exception.OperatorNotFoundException;
import models.Operator;

import java.util.HashMap;
import java.util.Map;

public class OperatorRepository {
    private Map<Integer, Operator> operatorMap;

    public OperatorRepository() {
        this.operatorMap = new HashMap<>();
    }

    public Operator getOperator(int operatorId) {
        if (operatorMap.containsKey(operatorId)) {
            return operatorMap.get(operatorId);
        } else {
            throw new OperatorNotFoundException("Operator with id "+operatorId+" not found.");
        }
    }

    public void setOperator(Operator operator) {
        operatorMap.put(operator.getId(), operator);
        System.out.println("Operator with id "+operator.getId()+" has been added successfully");
    }
}
