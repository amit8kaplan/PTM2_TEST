//package test;
//
//import test.MyRecursiveTask;
//
//public class BE extends MyRecursiveTask<Double> implements Expression{
//	char operator;
//	private static final long serialVersionUID = 1L;
//	Expression left;
//	Expression right;
//
//	public BE(char operator, Expression left, Expression right) {
//		this.operator = operator;
//		this.left = left;
//		this.right =right;
//	}
//	public BE(BE be){
//		this.operator= be.operator;
//		this.right = be.right;
//		this.left =be.left;
//	}
//
//
//	public Double helpMethodToCalc(char ch, Double left, Double right){
//		Double res =0.0;
//		switch (ch){
//			case '+':
//				res = left + right;
//				break;
//			case '-':
//				res = left - right;
//				break;
//			case '*':
//				res = left * right;
//				break;
//			case '/':
//				res = left / right;
//				break;
//			default:
//				res = 0.0;
//		}
//		return res;
//	}
//	@Override
//	protected Double compute() {
//		Double res = 0.0;
//		if (!(right instanceof BE))
//			res = helpMethodToCalc(operator,this.left.calculate(), this.right.calculate());
//		else {
//			((BE) this.right).testFork();
//			res = helpMethodToCalc(operator, this.left.calculate(), ((BE) this.right).join().doubleValue());
//		}
//		return  res;
////
////		double r=0;
////		if(right instanceof BE)
////			((BE)(right)).testFork();
////		else
////			r=right.calculate();
////
////		double result=left.calculate();
////
////		if(right instanceof BE)
////			r=((BE)(right)).join();
////
////		switch(operator){
////			case '+': result+= r; break;
////			case '-': result-= r; break;
////			case '*': result*= r; break;
////			case '/': result/= r; break;
////		}
////		return result;
//
//	}
//
//	@Override
//	public Double calculate() {
//		return compute();
//	}
//}
