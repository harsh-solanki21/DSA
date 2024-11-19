package Stack;

import java.util.Stack;

public class EvaluatePostfix {

    // https://www.geeksforgeeks.org/evaluation-of-postfix-expression/
    // TC - O(N), SC - O(N)

    static int evaluatePostfix(String str) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ' ') {
                continue;
            } else if (ch >= '0' && ch <= '9') {  // Character.isDigit(ch)
                int n = 0;
                while (ch >= '0' && ch <= '9') {
                    n = n * 10 + (ch - '0');
                    i++;
                    ch = str.charAt(i);
                }
                i--;
                st.push(n);
            } else {
                int val1 = st.pop();
                int val2 = st.pop();

                switch (ch) {
                    case '+':
                        st.push(val2 + val1);
                        break;
                    case '-':
                        st.push(val2 - val1);
                        break;
                    case '/':
                        st.push(val2 / val1);
                        break;
                    case '*':
                        st.push(val2 * val1);
                        break;
                }
            }
        }

        return st.pop();
    }


    public static void main(String[] args) {
        String exp = "100 200 + 2 / 5 * 7 +";
        System.out.println(evaluatePostfix(exp));
    }

}
