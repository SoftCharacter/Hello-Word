import java.util.ArrayDeque;
import java.util.Deque;

//�������㷨 ��������沨��ʽ ʵ��ԭ��https://baike.baidu.com/item/%E9%80%86%E6%B3%A2%E5%85%B0%E5%BC%8F/128437?fr=aladdin
//ת��ԭ��https://blog.csdn.net/oWuFeng1/article/details/40863355
/**
 * 
 *�沨��ʽ
 *�ܽᣬjava���Eval���沨���Ͷ�̬���룬�Ƽ��ö�̬���룬��Ϊ�沨��ʽ����ʶ"- 4"��ֻ��ʶ"-4"���Ҷ�̬����򵥲�������Ҷ�̬�������ִ���κ����
 *@author  
 */
public class �沨���㷨 {
/**
* ������
*/
private static Deque<String> operationNum = new ArrayDeque<String>();
/**
* �����
*/
private static Deque<String> operator = new ArrayDeque<String>();
/**
* �����ʽת��Ϊ�沨��ʽ
* @param expression
* @return
*/
static String resultNum;
public �沨���㷨(String str) {
	resultNum = str;
}
public �沨���㷨() {
	
}
private static void str2HandleOperator(String expression){
operationNum.clear();
operator.clear();
int index = 0;
for(int i=0;i<expression.length();i++){
char c  = expression.charAt(i);
if(isOperator(c) || c=='(' || c==')'){
//������ֱ����ջ
String operationNum = expression.substring(index,i);
//���ָ��źͼ���,���'-'ǰ���һ����+-*/( ��Ϊ�Ǹ���,'-'ǰ���������)��Ϊ�Ǽ���
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
�沨���㷨.operationNum.push(operationNum.trim());
}
index = i+1;
String operator = c+"";
//�����������'('��ֱ����ջ
if('('==c){
�沨���㷨.operator.push(operator);
//�����������')'����'('������֮���ȫ����ջ����ջ��������'(' ')'����
}else if(')'==c){
while(true){
String o = �沨���㷨.operator.pollFirst();
if(o==null || "(".equals(o)){
break;
}
�沨���㷨.operationNum.push(o);
}
//�����������+-*/
}else{
String o = �沨���㷨.operator.peekFirst();
if(o== null){//���������ջΪ�գ�������ֱ����ջ
�沨���㷨.operator.push(operator);
}else {
char operator2 = o.charAt(0);
//�Ƚϲ��������Ͳ�����ջ�� �Ĵ�С�������������ֱ����ջ
if(operator2=='(' || operator2==')' || orderOperator(c,operator2)){
�沨���㷨.operator.push(operator);
//���������ջ�״󣬽�������ջС�ڲ�������ȫ����ջ����ջ�����������Ĳ�������ջ
}else{
while(true){
if(o==null || o.charAt(0) =='('|| o.charAt(0) ==')'){
break;
}
if(orderOperator(c, o.charAt(0))){
break;
}
o = �沨���㷨.operator.pollFirst();
�沨���㷨.operationNum.push(o);
o = �沨���㷨.operator.peekFirst();
}
�沨���㷨.operator.push(operator);
}
}
}
}
}
String operationNum = expression.substring(index);
if(operationNum.trim().length()>0){
�沨���㷨.operationNum.push(operationNum.trim());
}
while(�沨���㷨.operator.size()>0){
�沨���㷨.operationNum.push(�沨���㷨.operator.pollFirst());
}
// HandleOperator.operationNum.addAll(HandleOperator.operator);
}
//�ж�һ���ַ��Ƿ�Ϊ�����  
    private static boolean isOperator(char c) {  
        return c=='+' || c=='-' || c=='*' || c=='/';
    }  
    //�ж������˳��true��ʾ�����operator1>operator2,false��ʾ��Ȼ�С��
    private static boolean orderOperator(char operator1, char operator2){
    if((operator1=='*' || operator1=='/') && (operator2=='+' || operator2=='-')){
    return true;
    }
    return false;
    }
/**
* �����沨��ʽ��ֵ
* @return
*/
    private static double countHandleOperator(){
while(�沨���㷨.operationNum.size()>0){
String s = �沨���㷨.operationNum.pollLast();
//����ǲ�������ȡ��ջ����������������ֱ������
char operator = s.charAt(0);
if(s.length()==1 && isOperator(operator)){
String a = �沨���㷨.operator.pollFirst();
String b = �沨���㷨.operator.pollFirst();
if('+'==operator){
double result =  Double.parseDouble(b)+Double.parseDouble(a);
�沨���㷨.operator.push(result+"");
}else if('-'==operator){
double result =  Double.parseDouble(b)-Double.parseDouble(a);
�沨���㷨.operator.push(result+"");
}if('*'==operator){
double result =  Double.parseDouble(b)*Double.parseDouble(a);
�沨���㷨.operator.push(result+"");
}if('/'==operator){
double result =  Double.parseDouble(b)/Double.parseDouble(a);
�沨���㷨.operator.push(result+"");
}
//����ǲ���������ջ
}else{
�沨���㷨.operator.push(s);
}
}
double result = Double.parseDouble(�沨���㷨.operator.pollLast());
return result;
}
/**
* �����沨��ʽ��ֵ(����)
* @return
*/
    private static int intHandleOperator(){
while(�沨���㷨.operationNum.size()>0){
String s = �沨���㷨.operationNum.pollLast();
//����ǲ�������ȡ��ջ����������������ֱ������
char operator = s.charAt(0);
if(s.length()==1 && isOperator(operator)){
String a = �沨���㷨.operator.pollFirst();
String b = �沨���㷨.operator.pollFirst();
if('+'==operator){
int result =  Integer.parseInt(b)+Integer.parseInt(a);
�沨���㷨.operator.push(result+"");
}else if('-'==operator){
int result =  Integer.parseInt(b)-Integer.parseInt(a);
�沨���㷨.operator.push(result+"");
}if('*'==operator){
int result =  Integer.parseInt(b)*Integer.parseInt(a);
�沨���㷨.operator.push(result+"");
}if('/'==operator){
int result =  Integer.parseInt(b)/Integer.parseInt(a);
�沨���㷨.operator.push(result+"");
}
//����ǲ���������ջ
}else{
�沨���㷨.operator.push(s);
}
}
int result = Integer.parseInt(�沨���㷨.operator.pollLast());
return result;
}
/**
* ������ʽ��ֵ
* @param expression
* @return
*/
public static double calculate(String expression){
try{
str2HandleOperator(expression);
return countHandleOperator();
}catch(Exception  e){
e.printStackTrace();
System.out.println("������ʽ");
return 0.0;
}
}
/**
* ������ʽ��ֵ(����)
* @param expression
* @return
*/
public static int intCalculate(String expression){
try{
str2HandleOperator(expression);
return intHandleOperator();
}catch(Exception e){
e.printStackTrace();
System.out.println("������ʽ");
return 0;
}
}

public static double returnNum() {  
//System.out.println(HandleOperator.intCalculate(str));
	 double result = �沨���㷨.calculate(resultNum);		 
	//System.out.println(result);
	return result;
}
}