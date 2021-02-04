package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];
            solutions[0] = new Solution(){{
                innerClasses = new Solution.InnerClass[]{new Solution().new InnerClass(), new Solution().new InnerClass()};
            }};
            solutions[1] = new Solution() {{
                innerClasses = new Solution.InnerClass[]{new Solution().new InnerClass(), new Solution().new InnerClass()};
            }};
        return solutions;
    }

    public static void main(String[] args) {

    }
}
