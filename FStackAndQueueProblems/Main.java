package FStackAndQueueProblems;

public class Main {
    // String Reverse using stack
    public static String reverseString(String newString){
        StackUsingArray s = new StackUsingArray();
        for (int i=0; i<newString.length(); i++) {
            s.push(newString.charAt(i));
        }
        String reversedString ="";
        while (!s.isEmpty()){
            reversedString += s.pop();
        }
        return  reversedString;
    }
    // Check If Parantheses is balanced
    public static boolean isBalancedParentheses(String parantheses){
        StackUsingArray s = new StackUsingArray();
        for (int i=0 ; i< parantheses.length();i++){
            if(parantheses.charAt(i) == '('){
                    s.push('(');
            }
            else if (parantheses.charAt(i) == ')'){
                if(s.isEmpty())
                    return false;
                s.pop();
            }
        }
        if(s.isEmpty())
            return true;
        return false;
    }

    public static void sortStack(StackUsingArray<Integer> old){
        StackUsingArray<Integer> newSt = new StackUsingArray();
        while (!old.isEmpty()){
            if(newSt.isEmpty()){
                newSt.push(old.pop());
            }else{
                if(old.peek() > newSt.peek()){
                    newSt.push(old.pop());
                }
                else{
                    int value = old.pop();
                    while (!newSt.isEmpty() && value < newSt.peek() ){
                        old.push(newSt.pop());
                    }
                    newSt.push(value);
                }
            }
        }
        while (!newSt.isEmpty()){
            old.push(newSt.pop());
        }
    }

    public static void main(String[] args) {
//        System.out.println(reverseString("hello world"));
//        System.out.println(isBalancedParentheses("()"));
        StackUsingArray<Integer> stack = new StackUsingArray<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();

        /*
            EXPECTED OUTPUT:
            ----------------
            Before sorting:
            4
            1
            5
            2
            3

            After sorting:
            1
            2
            3
            4
            5

        */

    }

}
