package com.example;

import com.example.interfaces.Optionable;
import com.example.menu.InsertCarTrade;
import com.example.menu.MainMenu;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Optionable> options = new ArrayList<com.example.interfaces.Optionable>();
        options.add(new InsertCarTrade());

        MainMenu mainMenu = new MainMenu(options);

        mainMenu.open();
    }
}
