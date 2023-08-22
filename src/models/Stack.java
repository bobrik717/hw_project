package models;

public class Stack {
    private Object[] objects = new Object[0];
    public void push(Object object) {
        Object[] tmp = new Object[objects.length + 1];
        tmp[0] = object;
        System.arraycopy(objects, 0, tmp, 1, tmp.length - 1);
        objects = tmp;
    }
    public Object pop() {
        if(objects.length == 0) {
            return null;
        }
        Object[] tmp = new Object[objects.length - 1];
        Object o = objects[0];
        System.arraycopy(objects, 1, tmp, 0, objects.length - 1);
        objects = tmp;
        return o;
    }
    public Object peek() {
        if(objects.length > 0) {
            return objects[0];
        }

        return null;
    }
    public Object[] getObjects() {
        return objects;
    }
}
