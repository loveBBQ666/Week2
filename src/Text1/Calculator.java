package Text1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要计算的表达式（不带空格,括号用英文）:");
        String expression = sc.nextLine();
        check(expression);
        System.out.print(value(brace(expression)));
    }

    public static void check(String expression){
        for(int i = 0;i < expression.length();i++){
            if(Character.isDigit(expression.charAt(i))||
                    expression.charAt(i) =='+'||
                    expression.charAt(i) =='-'||
                    expression.charAt(i) =='*'||
                    expression.charAt(i) =='/'||
                    expression.charAt(i) =='('||
                    expression.charAt(i) ==')'||
                    expression.charAt(i) =='.'
            ){}else if(expression.charAt(i) =='='){
                expression = expression.substring(0,expression.length()-1);
            }else{
                throw new RuntimeException("非法的输入");
            }
        }

        int a = 0,b = 0;
        for(int i = 0;i < expression.length();i++){
            if(expression.charAt(i) =='(')a++;
            if(expression.charAt(i) ==')')b++;
        }
`
        if(a != b)throw new RuntimeException("括号数不匹配");
    }




    public static String brace(String expression){
        int i;
        for(i = 0;i < expression.length();i++){
            if(expression.charAt(i) == ')'){
                break;
            }else if(i == expression.length()-1){
                return expression;
            }
        }

        int j = i;
        while(expression.charAt(j) !='('){
            j--;
        }
        j++;

        String s = expression.substring(j,i);
        String value = String.valueOf(value(s));
        expression = expression.replace('(' + s + ')',value);
        return brace(expression);
    }

    public static double value(String expression){
        for(int i = 0;i < expression.length();i++){
            if(expression.charAt(i) == '*'){
                int a1 = i - 1,a2 = i;
                int b1 = i + 1,b2 = i+1;

                while (Character.isDigit(expression.charAt(a1))||expression.charAt(a1) == '.'||expression.charAt(a1) == '-'){
                    a1--;
                    if(a1 == -1){
                        break;
                    }
                }a1++;
                double a = Double.parseDouble(expression.substring(a1,a2));

                if(expression.charAt(b2) == '-')b2++;
                while (Character.isDigit(expression.charAt(b2)) || expression.charAt(b2) == '.' ) {
                    b2++;
                    if(b2 == expression.length()){
                        break;
                    };
                }
                double b = Double.parseDouble(expression.substring(b1,b2));
                double c = a * b;
                String new1 = Double.toString(c);
                String old = expression.substring(a1,b2);
                expression = expression.replace(old,new1);
                return value(expression);
            }else if(expression.charAt(i) =='/'){
                int a1 = i - 1,a2 = i;
                int b1 = i + 1,b2 = i+1;

                while (Character.isDigit(expression.charAt(a1))||expression.charAt(a1) == '.'||expression.charAt(a1) == '-'){
                    a1--;
                    if(a1 == -1){
                        break;
                    }
                }a1++;
                double a = Double.parseDouble(expression.substring(a1,a2));
                if(expression.charAt(b2) == '-')b2++;
                while (Character.isDigit(expression.charAt(b2)) || expression.charAt(b2) == '.' ) {
                    b2++;
                    if(b2 == expression.length()){
                        break;
                    };
                }
                double b = Double.parseDouble(expression.substring(b1,b2));
                double c = a / b;
                String new1 = Double.toString(c);
                String old = expression.substring(a1,b2);
                expression = expression.replace(old,new1);
                return value(expression);
            }
        }
        for(int i = 0;i < expression.length();i++) {
            if (expression.charAt(i) == '+') {
                int a1 = i - 1, a2 = i;
                int b1 = i + 1, b2 = i + 1;

                while (Character.isDigit(expression.charAt(a1)) || expression.charAt(a1) == '.' || expression.charAt(a1) == '-') {
                    a1--;
                    if (a1 == -1) {
                        break;
                    }
                }
                a1++;
                double a = Double.parseDouble(expression.substring(a1, a2));
                if(expression.charAt(b2) == '-')b2++;
                while (Character.isDigit(expression.charAt(b2)) || expression.charAt(b2) == '.' ) {
                    b2++;
                    if (b2 == expression.length()) {
                        break;
                    }

                }
                double b = Double.parseDouble(expression.substring(b1, b2));
                double c = a + b;
                String new1 = Double.toString(c);
                String old = expression.substring(a1, b2);
                expression = expression.replace(old, new1);
                return value(expression);
            }
        }

        for(int i = 0;i < expression.length();i++){

            if(expression.charAt(i) =='-'){
                int a1 = i - 1,a2 = i;
                int b1 = i + 1,b2 = i+1;

                if(a1 == -1){

                    expression = expression.replace("--","+");
                    for(int j = 0;j < expression.length();j++){
                        if(expression.charAt(j) =='+'){
                            return value(expression);
                        }
                    }

                    for(int j = 1;j < expression.length();j++){
                        if(expression.charAt(j) =='-'){
                            expression = expression.replace('-','+').substring(1);
                            return -value(expression);

                        }
                    }

                    return Double.parseDouble(expression);
                }
                while (Character.isDigit(expression.charAt(a1))||expression.charAt(a1) == '.'||expression.charAt(a1) == '-'){
                    a1--;
                    if(a1 == -1){
                        break;
                    }
                }a1++;
                double a = Double.parseDouble(expression.substring(a1,a2));
                if(expression.charAt(b2) == '-')b2++;
                while (Character.isDigit(expression.charAt(b2)) || expression.charAt(b2) == '.' ) {
                    b2++;
                    if(b2 == expression.length()){
                        break;
                    };
                }
                double b = Double.parseDouble(expression.substring(b1,b2));
                double c = a - b;
                String new1 = Double.toString(c);
                String old = expression.substring(a1,b2);
                expression = expression.replace(old,new1);
                return value(expression);
            }
        }
        return Double.parseDouble(expression);

    }


}
