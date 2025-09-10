public class ExpressionSolver {
	private String expression;
	private String ret;

	public ExpressionSolver(String s) {
		expression = s.replaceAll(" ", "");
		ret = s;
	}

	public void setExpression(String s) {
		expression = s.replaceAll(" ", "");
		ret = s;
	}

	public void solveExpression() {
		while (expression.contains("(")) {
			int openIdx = expression.lastIndexOf("(");
			int closeIdx = expression.indexOf(")", openIdx);
			String subExpr = expression.substring(openIdx + 1, closeIdx);

			subExpr = solveExpression(subExpr);

			expression = expression.substring(0, openIdx) + subExpr + expression.substring(closeIdx + 1);
		}

		expression = solveExpression(expression);
	}

	private String solveExpression(String expr) {
		expr = expr.replaceAll(" ", "");

		while (expr.contains("*") || expr.contains("/")) {
			expr = solveMulDiv(expr);
		}

		while (expr.contains("+") || expr.contains("-")) {
			expr = solveAddSub(expr);
			if (expr.startsWith("-")) break;
		}

		return expr;
	}

	private String solveMulDiv(String expr) {
		int i = 0;
		while (i < expr.length()) {
			char ch = expr.charAt(i);
			if (ch == '*' || ch == '/') {
				// Find the two operands around the operator
				int leftStart = i - 1;
				while (leftStart >= 0 && Character.isDigit(expr.charAt(leftStart))) {
					leftStart--;
				}
				int leftOperand = Integer.parseInt(expr.substring(leftStart + 1, i));

				int rightEnd = i + 1;
				while (rightEnd < expr.length() && Character.isDigit(expr.charAt(rightEnd))) {
					rightEnd++;
				}
				int rightOperand = Integer.parseInt(expr.substring(i + 1, rightEnd));

				int result = 0;
				if (ch == '*') {
					result = multiply(leftOperand, rightOperand);
				} else {
					if (rightOperand == 0) throw new ArithmeticException("Cannot divide by zero");
					result = divide(leftOperand, rightOperand);
				}

				expr = expr.substring(0, leftStart + 1) + result + expr.substring(rightEnd);
				i = leftStart + String.valueOf(result).length();
			} else {
				i++;
			}
		}
		return expr;
	}

	private String solveAddSub(String expr) {
		int i = 0;
		while (i < expr.length()) {
			char ch = expr.charAt(i);
			if ((ch == '+' || ch == '-') && i > 0) {
				int leftStart = i - 1;
				while (leftStart >= 0 && (Character.isDigit(expr.charAt(leftStart)) || expr.charAt(leftStart) == '-')) {
					leftStart--;
				}
				int leftOperand = Integer.parseInt(expr.substring(leftStart + 1, i));

				int rightEnd = i + 1;
				while (rightEnd < expr.length() && Character.isDigit(expr.charAt(rightEnd))) {
					rightEnd++;
				}
				int rightOperand = Integer.parseInt(expr.substring(i + 1, rightEnd));

				int result = 0;
				if (ch == '+') {
					result = add(leftOperand, rightOperand);
				} else {
					result = subtract(leftOperand, rightOperand);
				}

				expr = expr.substring(0, leftStart + 1) + result + expr.substring(rightEnd);
				i = leftStart + String.valueOf(result).length();
			} else {
				i++;
			}
		}
		return expr;
	}


	public String toString() {
		return ret + " = " + expression;
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public static int subtract(int a, int b) {
		return a - b;
	}

	public static int multiply(int a, int b) {
		return a * b;
	}

	public static int divide(int a, int b) {
		if (b == 0) throw new ArithmeticException("Cannot divide by zero");
		return a / b;
	}
}
