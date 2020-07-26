package in.teja;

import java.awt.*;
import java.awt.event.*;

public class GraphicalUSerInterface extends Frame{
    TextField operand1;
    Button sum;
    TextField operand2;
    Button difference;
    Button multiplication;
    Button division;
    Label equal;
    Label Error;
    TextField result;

    public GraphicalUSerInterface(){
        initializeComponents();
        addComponentsToFrame();
        addListenerInterfaces();
    }

    private void initializeComponents() {
        operand1=new TextField(10);
        sum = new Button("+");
        difference = new Button("-");
        multiplication = new Button("*");
        division = new Button("/");
        operand2=new TextField(10);
        result=new TextField(10);
        equal=new Label("=");
        result.setEditable(false);

    }

    private void addComponentsToFrame() {
        setLayout(new FlowLayout());
        add(operand1);
        add(sum);
        add(difference);
        add(multiplication);
        add(division);
        add(operand2);
        add(equal);
        add(result);
    }

    private void addListenerInterfaces() {
        addWindowListener(new WindowClosingAdapter());
        sum.addActionListener(new CalculatorActionListener());
        difference.addActionListener(new CalculatorActionListener());
        division.addActionListener(new CalculatorActionListener());
        multiplication.addActionListener(new CalculatorActionListener());

    }
    private class WindowClosingAdapter extends WindowAdapter
    {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    private class CalculatorActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            Calculator cal=new Calculator();
            try{
                int o1=Integer.parseInt(operand1.getText());

                int o2=Integer.parseInt(operand2.getText());
                cal.setOperand1(o1);
                cal.setOperand2(o2);
                if(e.getSource()==sum)
                    cal.add();
                if(e.getSource()==division)
                    cal.divide();
                if(e.getSource()==difference)
                    cal.subtract();
                if(e.getSource()==multiplication)
                    cal.multiply();
            }
            catch(Exception E) {
                Error=new Label("You better add some values");
                add(Error);
            }
            result.setText(String.valueOf(cal.getResult()));


        }

    }
}
