package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;


public class ReadFromFile {
	//定义一个数组res，每次从文件中读取到的内容存放进该数组
	public static List res;
	
	/**
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     */
	public static void readFileByByte(String fileName){
		
		//fileName = "E:\\apiTestFiles\\readFile.txt";
		fileName = "E:\\Softwares\\jars\\appmodels.txt";
		
		File file = new File(fileName);
		InputStream in = null;
		
		try {
			System.out.println("以字节为单位读取文件，一次读取一个字节");
			//一次读取一个字节
			in = new FileInputStream(file);
			int tempByte;
			while((tempByte=in.read())!=-1){
				System.out.write(tempByte);
			}
			System.out.println("\n");
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		try {
			System.out.println("以字节为单位读取文件内容，一次读取多个！");
			//一次读多个字节
			byte[] tempBytes = new byte[100];
			int byteRead = 0;
			in = new FileInputStream(fileName);
			//调用showAvailableBytes方法获取当前输入流中还剩余的字节数
			ReadFromFile.showAvailableBytes(in);
			while((byteRead=in.read(tempBytes))!=-1){
				System.out.write(tempBytes, 0, byteRead);	
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		}	
		
	}
	
	
	/**
	 * 
	 * 以字符为单位读取文件,常用语读取文本、数字类型等的文件
	 * @param in
	 */
	public static void readFileByChar(String fileName){
		File file = new File(fileName);
		Reader reader = null;
		System.out.println("\r"+"\r"+"*******************");
		try {
			System.out.println("以字符为单独读取文件内容，一次读取一个字符");
			//一次读一个字符
			reader = new InputStreamReader(new FileInputStream(file));
			int tempchar;
			while((tempchar=reader.read())!=-1){
				//windowd下，\r和\n这两个字符在一起时代表换行
				//但如果两个字符分开时，会换两次行
				//因此，需要屏蔽掉\r或者\n，避免换很多次行
				if(((char)tempchar)!='\r'){
					System.out.print((char)tempchar);
				}
			}
			//关闭流
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			System.out.print("\r");
			System.out.println("以字符为单独读取文件内容，一次读取多个字符");
			char[] tempchars = new char[10];
			int charReader = 0;
			reader = new InputStreamReader(new FileInputStream(file));
			//读取多个字符到字符数组中，charReader为一次读取到的字符数
			while((charReader=reader.read(tempchars))!=-1){
				//屏蔽掉读取到的字符数组末尾的\r或者\n
				if((charReader==tempchars.length)
						&& (tempchars[tempchars.length-1]!=-1)){
					System.out.print(tempchars);
				}
				//屏蔽掉读取到的字符数组中的\r或者\n
				else{
					for(int i=0; 1<charReader;i++){
						if(tempchars[i]!='\r'){
							System.out.print(tempchars[i]);
						}else{
							continue;
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * 以行为单位读取文件内容，常用于面向行的格式化文件
	 * @param in
	 */
	public static String readerFileByString(String fileName){
		BufferedReader reader = null;
		File file = new File(fileName);
		String tempstring= "";
		String tempstring1= "";
		//System.out.print("\r");
		try {
			
			//System.out.println("****************"+"\r"+"以行为单位读取文件内容，一次读取一行");
			reader = new BufferedReader(new FileReader(file));
			//一次读取一行，直到读入null为文件结束
			   while ((tempstring=reader.readLine())!=null){
				   tempstring1+=tempstring;    
				   System.out.println(tempstring);
			   }
			reader.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return tempstring1;
		
	}
	
	/**
	 * 
	 * @param in
	 */
	public static List lreaderFileByString(String fileName){
		
		BufferedReader lreader = null;
		File lfile = new File(fileName);
		//定义一个string类型的变量ltempstring用于存放每次从文件中读取到的每行的内容
		String ltempstring="";
		
		//在将每次读取到的文件内容存入List之前，判断List中是否已经存在该内容
		res = new ArrayList();
		
		try {
			lreader = new BufferedReader(new FileReader(lfile));
			while((ltempstring=lreader.readLine())!=null){
				res.add(ltempstring);
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		return res;
		
	}
	
	
	//显示输入流中还剩余的字节数
	private static void showAvailableBytes(InputStream in) {
		// TODO Auto-generated method stub
		try {
			System.out.println("当前字节输入流中的字节数为："+in.available());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName = "E:\\Softwares\\jars\\appmodels.txt";
		//按照方法A读取文件内容
		//ReadFromFile.readFileByByte(fileName);
		//按照方法B读取文件内容
		//ReadFromFile.readFileByChar(fileName);
		//按照方法C读取文件内容
		//System.out.println(ReadFromFile.readerFileByString(fileName));
		
		System.out.println(lreaderFileByString(fileName));
		
	}

}
