package Individual;

import java.io.*;
import java.util.Scanner;


public class Questions {
	private int[] a = new int [500];
	private int[] b = new int [500];
	private int[] c = new int [500];//第三个数
	private int[] d = new int [500];
	private int[] mid = new int [500];
	private int[] result = new int [500];
	
	public String[] setQuestion(int n) {
		int random = 0;
		String[] questions = new String[n];
		String question = null  ;
		boolean flag = false;
		
		if(n>100) {
			System.out.println("请输入100以内的数字。");
		}else {
			for(int i=0;i<n;i++) {
				random = (int)(Math.random()*10);
				if(random>=0&&random<=2) {
					a[i] = (int)(Math.random()*100);
					b[i] = (int)(Math.random()*100);
					result[i] = a[i] + b[i];
					d[i] = 1;
					question = a[i]+"+"+b[i]+"=";
				}else if(random>=3&&random<=5){
					a[i] = (int)(Math.random()*100);
					b[i] = (int)(Math.random()*100);
					if(a[i]<b[i]) {
						int temp = 0;
						temp = a[i];
						a[i] = b[i];
						b[i] = temp;
					}
					result[i] = a[i] - b[i];
					d[i] = 2;
					question = a[i]+"-"+b[i]+"=";

				}else if(random>=6&&random<=9) {
					a[i] = (int)(Math.random()*100);
					b[i] = (int)(Math.random()*100);
					c[i] = (int)(Math.random()*100);
					int r2 = (int)(Math.random()*100);
					if(r2>=0&&r2<=24) {
						result[i] = a[i]+b[i]+c[i];
						d[i] = 3;
						question = a[i]+"+"+b[i]+"+"+c[i]+"=";
					}else if(r2>=25&&r2<=49) {
						mid[i] = a[i]+b[i];
						if ( mid[i]<c[i]) {
							i--;
							continue;
						}
						result[i] = a[i]+b[i]-c[i];
						d[i] = 4;
						question = a[i]+"+"+b[i]+"-"+c[i]+"=";
					}else if(r2>=50&&r2<=74) {
						if(a[i]<b[i]) {
							i--;
							continue;
						}
						result[i] = a[i]-b[i]+c[i];
						d[i] = 5;
						question = a[i]+"-"+b[i]+"+"+c[i]+"=";
					}else if(r2>=75) {
						mid[i] = b[i]+c[i];
						if(a[i]<mid[i]) {
							i--;
							continue;
						}
						result[i] = a[i] - b[i] - c[i];
						d[i] = 6;
						question = a[i]+"-"+b[i]+"-"+c[i]+"=";
					}
					
				}
				if(result[i]>100) {
						i--;
						continue;
				}
				
				for(int j=0;j<questions.length;j++) {
					if(questions[j]== question ) {
						flag = true;
						break;
					}
				}
				
				if(flag) {
					i--;
					continue;
				
				}
				questions[i] = question;
			}	
		}
		
		return questions;
	
	}

	public String[] setAnswer(int n) {
		String[] answers = new String[n];
		for(int i=0;i<n;i++) {
			if(d[i] == 1) {
				answers[i] = a[i]+"+"+b[i]+"="+result[i];
				
			} else if (d[i] == 2) {
				answers[i] = a[i]+"-"+b[i]+"="+result[i];
				
			}else if(d[i] == 3) {
				answers[i] = a[i]+"+"+b[i]+"+"+c[i]+"="+result[i];
				
			}else if(d[i] == 4) {
				answers[i] = a[i]+"+"+b[i]+"-"+c[i]+"="+result[i];
				
			}else if(d[i] == 5) {
				answers[i] = a[i]+"-"+b[i]+"+"+c[i]+"="+result[i];
				
			}else if(d[i] == 6) {
				answers[i] = a[i]+"-"+b[i]+"-"+c[i]+"="+result[i];
				
			}
			
		}
		return answers;
	}
	
	public static void main (String[] args) {
		// TODO Auto-generated method stub
		long startTime_N = System.currentTimeMillis();
		System.out.println("请输入所需的题目数量：");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Questions q1 = new Questions();
		String str1 = "C:\\Users\\lenovo\\eclipse-workspace\\Individual work\\src\\Individual\\Exercises.txt";
		String str2 ="C:\\Users\\lenovo\\eclipse-workspace\\Individual work\\src\\Individual\\Answers.txt";
		String[] questions  = q1.setQuestion(n);
		String[] answers = q1.setAnswer(n);
		try {
			File f1 = new File(str1);
			File f2 = new File(str2);
			f1.createNewFile();
			f2.createNewFile();
			
			if (f1.isFile()&&f1.exists()&&f2.isFile()&&f2.exists()) {
				FileWriter w1 = new FileWriter(f1);
				FileWriter w2 = new FileWriter(f2);
				for(int i=0;i<questions.length;i++) {
					
					w1.write(i+1+". "+questions[i]);	
					w1.write("\r\n");
					w2.write(i+1+". "+answers[i]);
					w2.write("\r\n");
					
				}
				w1.close();
				w2.close();
			}else {
				System.out.println("File doesn't exist.");
			}
			
		}catch(IOException e ) {
			e.printStackTrace();
		}
		long endTime_N = System.currentTimeMillis();
		System.out.println("程序运行时间："+(endTime_N-startTime_N)+"ms");
	}	
}

