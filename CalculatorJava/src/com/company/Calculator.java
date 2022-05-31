package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{


    JFrame window;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton,subButton,multiButton,divButton;
    JButton decButton,equalButton,delButton,clrButton,negativeButton;
    JPanel panel;

    Font mFont = new Font("Time New Roman",Font.BOLD,25);


    double num1=0,num2=0,result=0;
    char operators;
    Calculator(){

        window = new JFrame("kalkulator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(420,550);
        window.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(mFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        multiButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("delete");
        clrButton = new JButton("clear");
        negativeButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negativeButton;
        for(int i  = 0;i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(mFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i  = 0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(mFont);
            numberButtons[i].setFocusable(false);
        }
            negativeButton.setBounds(50,430,100,50);
            delButton.setBounds(150,430,100,50);
            clrButton.setBounds(250,430,100,50);

            panel = new JPanel();
            panel.setBounds(50,100,300,300);
            panel.setLayout(new GridLayout(4,4,10,10));
            panel.setBackground(Color.pink);

            panel.add(numberButtons[1]);
            panel.add(numberButtons[2]);
            panel.add(numberButtons[3]);
            panel.add(addButton);
             panel.add(numberButtons[4]);
             panel.add(numberButtons[5]);
             panel.add(numberButtons[6]);
             panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);
        window.add(panel);
        window.add(negativeButton);
        window.add(delButton);
        window.add(clrButton);
        window.add(textfield);
        window.setVisible(true);
    }
    public static void main(String[] args) {

        Calculator calc  = new Calculator();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        for(int i=0;i<10;i++){
            if(e.getSource() == numberButtons[i]){
            textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            operators = '+';
            textfield.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textfield.getText());
            operators = '-';
            textfield.setText("");
        }
        if(e.getSource() == multiButton){
            num1 = Double.parseDouble(textfield.getText());
            operators = '*';
            textfield.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            operators = '/';
            textfield.setText("");
        }
        if(e.getSource()== equalButton){
            num2= Double.parseDouble(textfield.getText());
            switch (operators){
                case'+':
                    result = num1 + num2;
                    break;
                case'-':
                    result = num1 - num2;
                    break;
                case'*':
                    result = num1 * num2;
                    break;
                case'/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 =result;
        }
        if(e.getSource() == clrButton){
            textfield.setText("");
    }
        if(e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
            if(e.getSource() ==negativeButton){
                double temp = Double.parseDouble(textfield.getText());
                temp*=-1;
                textfield.setText(String.valueOf(temp));
                }
        }
        }


