package com.example.menu;

import com.example.exceptions.InvalidOptionException;
import com.example.interfaces.Optionable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private List<Optionable> options = new ArrayList<Optionable>();

    public MainMenu() {
    }

    public MainMenu(List<Optionable> options) {
        this.options = options;
    }

    public void open() {
        while (true) {
            System.out.println(draw());
            try {
                options.get(checkOption() - 1).select();
            } catch (InvalidOptionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String draw() {
        StringBuilder message = new StringBuilder("Welcome!\n");
        message.append("Choose an option:\n");

        int i = 1;
        for (Optionable line : options)
            message.append(i++).append(" - ").append(line.draw());

        return message.toString();
    }

    public int checkOption()
            throws InvalidOptionException {
        Scanner l = new Scanner(System.in);
        if (l.hasNextInt()) {
            int option = l.nextInt();
            if (option > options.size() || option <= 0)
                throw new InvalidOptionException();

            l.nextLine();
            return option;
        }

        throw new InvalidOptionException();
    }

    public List<Optionable> getOptions() {
        return options;
    }

    public void setOptions(List<Optionable> options) {
        this.options = options;
    }
}
