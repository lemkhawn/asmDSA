package Controller;

import Entity.Queue;
import Entity.Stack;
import Interface.ITransfer;

public class CTransfer implements ITransfer<Queue, Stack> {
    @Override
    public void transfer(Queue list1, Stack list2) {
        String temp = null;
        while (!list1.isEmpty()) {
            temp = list1.dequeue();
            list2.push(temp);
        }
    }
    
}
