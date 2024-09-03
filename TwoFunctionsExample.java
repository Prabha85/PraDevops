public class TwoFunctionsExample {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;

        int sum = addNumbers(num1, num2);
        System.out.println("Sum: " + sum);

        int product = multiplyNumbers(num1, num2);
        System.out.println("Product: " + product);
    }

    // Function to add two numbers
    public static int addNumbers(int a, int b) {
        return a + b;
    }

    // Function to multiply two numbers
    public static int multiplyNumbers(int a, int b) {
        return a * b;
    }
}

//pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/JavaJenkinsPrac.git'
            }
        }

        stage('Build') {
            steps {
                // Compile the Java code using Windows batch command
                bat 'javac TwoFunctionsExample.java'
            }
        }

        stage('Test and Run') {
            steps {
                // Run your Java program using Windows batch command
                bat 'java TwoFunctionsExample'
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}//
