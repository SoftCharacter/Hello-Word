import java.util.ArrayDeque;
import java.util.Deque;

//计算器算法 这里采用逆波兰式 实现原理：https://baike.baidu.com/item/%E9%80%86%E6%B3%A2%E5%85%B0%E5%BC%8F/128437?fr=aladdin
//转化原理：https://blog.csdn.net/oWuFeng1/article/details/40863355
/**
 * 
 *逆波兰式
 *总结，java版的Eval：逆波兰和动态编译，推荐用动态编译，因为逆波兰式不认识"- 4"，只认识"-4"，且动态编译简单不会出错，且动态编译可以执行任何语句
 *@author  
 */
public class 逆波兰算法 {
/**
* 运算数
*/
private static Deque<String> operationNum = new ArrayDeque<String>();
/**
* 运算符
*/
private static Deque<String> operator = new ArrayDeque<String>();
/**
* 将表达式转换为逆波兰式
* @param expression
* @return
*/
static String resultNum;
public 逆波兰算法(String str) {
	resultNum = str;
}
public 逆波兰算法() {
	
}
private static void str2HandleOperator(String expression){
operationNum.clear();
operator.clear();
int index = 0;
for(int i=0;i<expression.length();i++){
char c  = expression.charAt(i);
if(isOperator(c) || c=='(' || c==')'){
//操作数直接入栈
String operationNum = expression.substring(index,i);
//区分负号和减号,如果'-'前面的一个是+-*/( 认为是负号,'-'前面的是数或)认为是减号
if(c=='-'){
int in = i;
while((expression.charAt(in-1)) ==' '){
in--;
if(in==0){
break;
}
}
if(in==0){
continue;
}
String previous = expression.substring(in-1,i);
if(isOperator(previous.charAt(0)) || previous.charAt(0)=='('){
continue;
}
}
if(operationNum.trim().length()>0){
逆波兰算法.operationNum.push(operationNum.trim());
}
index = i+1;
String operator = c+"";
//如果操作符是'('，直接入栈
if('('==c){
逆波兰算法.operator.push(operator);
//如果操作符是')'，将'('操作符之后的全部出栈，入栈操作数，'(' ')'舍弃
}else if(')'==c){
while(true){
String o = 逆波兰算法.operator.pollFirst();
if(o==null || "(".equals(o)){
break;
}
逆波兰算法.operationNum.push(o);
}
//如果操作符是+-*/
}else{
String o = 逆波兰算法.operator.peekFirst();
if(o== null){//如果操作符栈为空，操作符直接入栈
逆波兰算法.operator.push(operator);
}else {
char operator2 = o.charAt(0);
//比较操作符，和操作符栈首 的大小，如果操作符大，直接入栈
if(operator2=='(' || operator2==')' || orderOperator(c,operator2)){
逆波兰算法.operator.push(operator);
//如果操作符栈首大，将操作符栈小于操作符的全部出栈，入栈操作数，最后改操作符入栈
}else{
while(true){
if(o==null || o.charAt(0) =='('|| o.charAt(0) ==')'){
break;
}
if(orderOperator(c, o.charAt(0))){
break;
}
o = 逆波兰算法.operator.pollFirst();
逆波兰算法.operationNum.push(o);
o = 逆波兰算法.operator.peekFirst();
}
逆波兰算法.operator.push(operator);
}
}
}
}
}
String operationNum = expression.substring(index);
if(operationNum.trim().length()>0){
逆波兰算法.operationNum.push(operationNum.trim());
}
while(逆波兰算法.operator.size()>0){
逆波兰算法.operationNum.push(逆波兰算法.operator.pollFirst());
}
// HandleOperator.operationNum.addAll(HandleOperator.operator);
}
//判断一个字符是否为运算符  
    private static boolean isOperator(char c) {  
        return c=='+' || c=='-' || c=='*' || c=='/';
    }  
    //判断运算符顺序，true表示运算符operator1>operator2,false表示相等或小于
    private static boolean orderOperator(char operator1, char operator2){
    if((operator1=='*' || operator1=='/') && (operator2=='+' || operator2=='-')){
    return true;
    }
    return false;
    }
/**
* 计算逆波兰式的值
* @return
*/
    private static double countHandleOperator(){
while(逆波兰算法.operationNum.size()>0){
String s = 逆波兰算法.operationNum.pollLast();
//如果是操作符，取出栈顶的两个操作数，直接运算
char operator = s.charAt(0);
if(s.length()==1 && isOperator(operator)){
String a = 逆波兰算法.operator.pollFirst();
String b = 逆波兰算法.operator.pollFirst();
if('+'==operator){
double result =  Double.parseDouble(b)+Double.parseDouble(a);
逆波兰算法.operator.push(result+"");
}else if('-'==operator){
double result =  Double.parseDouble(b)-Double.parseDouble(a);
逆波兰算法.operator.push(result+"");
}if('*'==operator){
double result =  Double.parseDouble(b)*Double.parseDouble(a);
逆波兰算法.operator.push(result+"");
}if('/'==operator){
double result =  Double.parseDouble(b)/Double.parseDouble(a);
逆波兰算法.operator.push(result+"");
}
//如果是操作数，入栈
}else{
逆波兰算法.operator.push(s);
}
}
double result = Double.parseDouble(逆波兰算法.operator.pollLast());
return result;
}
/**
* 计算逆波兰式的值(整数)
* @return
*/
    private static int intHandleOperator(){
while(逆波兰算法.operationNum.size()>0){
String s = 逆波兰算法.operationNum.pollLast();
//如果是操作符，取出栈顶的两个操作数，直接运算
char operator = s.charAt(0);
if(s.length()==1 && isOperator(operator)){
String a = 逆波兰算法.operator.pollFirst();
String b = 逆波兰算法.operator.pollFirst();
if('+'==operator){
int result =  Integer.parseInt(b)+Integer.parseInt(a);
逆波兰算法.operator.push(result+"");
}else if('-'==operator){
int result =  Integer.parseInt(b)-Integer.parseInt(a);
逆波兰算法.operator.push(result+"");
}if('*'==operator){
int result =  Integer.parseInt(b)*Integer.parseInt(a);
逆波兰算法.operator.push(result+"");
}if('/'==operator){
int result =  Integer.parseInt(b)/Integer.parseInt(a);
逆波兰算法.operator.push(result+"");
}
//如果是操作数，入栈
}else{
逆波兰算法.operator.push(s);
}
}
int result = Integer.parseInt(逆波兰算法.operator.pollLast());
return result;
}
/**
* 计算表达式的值
* @param expression
* @return
*/
public static double calculate(String expression){
try{
str2HandleOperator(expression);
return countHandleOperator();
}catch(Exception  e){
e.printStackTrace();
System.out.println("请检查表达式");
return 0.0;
}
}
/**
* 计算表达式的值(整数)
* @param expression
* @return
*/
public static int intCalculate(String expression){
try{
str2HandleOperator(expression);
return intHandleOperator();
}catch(Exception e){
e.printStackTrace();
System.out.println("请检查表达式");
return 0;
}
}

public static double returnNum() {  
//System.out.println(HandleOperator.intCalculate(str));
	 double result = 逆波兰算法.calculate(resultNum);		 
	//System.out.println(result);
	return result;
}
}