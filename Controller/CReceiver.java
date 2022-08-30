package Controller;

import Entity.Stack;
import Interface.IReceive;

public class CReceiver implements IReceive<Stack> {

    @Override
    public void read(Stack list) {
        list.show();
    }
}
