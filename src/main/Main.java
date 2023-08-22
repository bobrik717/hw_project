package main;

import models.Stack;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Stack stackModel = new Stack();

        stackModel.push(1);
        stackModel.push("sfsdf");
        stackModel.push(new int[] {1,2,3,4,5});

        System.out.println(Arrays.toString(stackModel.getObjects()));
        System.out.println(stackModel.pop());
        System.out.println(Arrays.toString(stackModel.getObjects()));
    }
}