package com.leetcode.codeguru.basics.trees;

public class TreeMain {

    public static void main(String[] Args) {
        TreeNode drinks = new TreeNode("Drinks");
        TreeNode hotDrink = new TreeNode("hot");
        TreeNode coldDrink = new TreeNode("cold");
        drinks.addChild(hotDrink);
        drinks.addChild(coldDrink);

        TreeNode coffee = new TreeNode("coffee");
        TreeNode tea = new TreeNode("tea");
        hotDrink.addChild(coffee);
        hotDrink.addChild(tea);

        TreeNode soda = new TreeNode("soda");
        TreeNode icetea = new TreeNode("icetea");
        coldDrink.addChild(soda);
        coldDrink.addChild(icetea);

        System.out.println(drinks.print(0));
    }
}
