
package javaapplication21;

import static java.lang.Character.isLetterOrDigit;
import java.util.Scanner;
import java.util.Stack;


public class InfixToPostfix {

    public class StackArray{
    int[] arr;
    int top;
    int size;
    public StackArray(int s){
        size =s;
        arr =new int[s];
        top=-1;
    }
    public boolean push(int data){
        if(!isFull())
        {
            arr[++top]=data;
        }
        return false;
    }
    public int pop(){
        if(top !=-1){
            return arr[top--];
        }
        return -1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==size-1;
    }
}
    public int check(char c){
   if(c>='0' &&c<='9'){
   return 1;
   }
   else 
       return 0;
   }
    public static int Priority(char c){
        switch(c){
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }

}
public static String infix_to_postfix(String exp){
	Stack s=new Stack();
	String output = "";
	
	for (int i = 0; i < exp.length(); i++){
            
         char c =exp.charAt(i);
         
         if(c>='0' &&c<='9')
             output += c;
         
         else if(c=='(')
             s.push(c);
         
         else if(c==')')
         {
         while(!s.isEmpty() && (char)s.peek() != '('){
         output += s.peek();
         s.pop();
         }
         s.pop();
         }
else{
         while(!s.isEmpty()&& Priority(c)<= Priority((char) s.peek())){
          output += s.peek();
         s.pop();
         }
         s.push(c);
         }
         }
 while(!s.isEmpty()){
       if( (char) s.peek()=='(')
           return "invalid Expression";
        output += s.peek();
       s.pop();
         }
      return output;
      }
public static int value_of_postfix(String post){
 Stack<Integer> s1=new Stack<>();
    for (int i = 0; i < post.length(); i++){
        char x=post.charAt(i);
        if(isLetterOrDigit(x)){
            s1.push(x -'0');
        }
        else{
            int x2=s1.pop();
            int x1=s1.pop();
             switch(x){
            case '+':
                 s1.push(x1+x2);
                     break;
            case '-':
                 s1.push(x1-x2);
                  break;
            case '/':
                 s1.push(x1/x2);
                  break;
            case '*':
               s1.push(x1*x2);
                break;
            case '^':
                s1.push(x1^x2);
                 break;
           
        }
    }
}
  return s1.pop();  
}

    public static void main(String[] args) {
        InfixToPostfix obj1 =new InfixToPostfix();
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter your infix Expression");   
        String infix=sc.nextLine();
        System.out.println("The expression of postfix is"+obj1.infix_to_postfix(infix));   
        String postfix =obj1.infix_to_postfix(infix);
        System.out.println("The value of postfix is"+obj1.value_of_postfix(postfix));
        
    }
    
}
