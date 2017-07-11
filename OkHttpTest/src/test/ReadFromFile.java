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
	//����һ������res��ÿ�δ��ļ��ж�ȡ�������ݴ�Ž�������
	public static List res;
	
	/**
     * ���ֽ�Ϊ��λ��ȡ�ļ��������ڶ��������ļ�����ͼƬ��������Ӱ����ļ���
     */
	public static void readFileByByte(String fileName){
		
		//fileName = "E:\\apiTestFiles\\readFile.txt";
		fileName = "E:\\Softwares\\jars\\appmodels.txt";
		
		File file = new File(fileName);
		InputStream in = null;
		
		try {
			System.out.println("���ֽ�Ϊ��λ��ȡ�ļ���һ�ζ�ȡһ���ֽ�");
			//һ�ζ�ȡһ���ֽ�
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
			System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�ȡ�����");
			//һ�ζ�����ֽ�
			byte[] tempBytes = new byte[100];
			int byteRead = 0;
			in = new FileInputStream(fileName);
			//����showAvailableBytes������ȡ��ǰ�������л�ʣ����ֽ���
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
	 * ���ַ�Ϊ��λ��ȡ�ļ�,�������ȡ�ı����������͵ȵ��ļ�
	 * @param in
	 */
	public static void readFileByChar(String fileName){
		File file = new File(fileName);
		Reader reader = null;
		System.out.println("\r"+"\r"+"*******************");
		try {
			System.out.println("���ַ�Ϊ������ȡ�ļ����ݣ�һ�ζ�ȡһ���ַ�");
			//һ�ζ�һ���ַ�
			reader = new InputStreamReader(new FileInputStream(file));
			int tempchar;
			while((tempchar=reader.read())!=-1){
				//windowd�£�\r��\n�������ַ���һ��ʱ������
				//����������ַ��ֿ�ʱ���ỻ������
				//��ˣ���Ҫ���ε�\r����\n�����⻻�ܶ����
				if(((char)tempchar)!='\r'){
					System.out.print((char)tempchar);
				}
			}
			//�ر���
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			System.out.print("\r");
			System.out.println("���ַ�Ϊ������ȡ�ļ����ݣ�һ�ζ�ȡ����ַ�");
			char[] tempchars = new char[10];
			int charReader = 0;
			reader = new InputStreamReader(new FileInputStream(file));
			//��ȡ����ַ����ַ������У�charReaderΪһ�ζ�ȡ�����ַ���
			while((charReader=reader.read(tempchars))!=-1){
				//���ε���ȡ�����ַ�����ĩβ��\r����\n
				if((charReader==tempchars.length)
						&& (tempchars[tempchars.length-1]!=-1)){
					System.out.print(tempchars);
				}
				//���ε���ȡ�����ַ������е�\r����\n
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
	 * ����Ϊ��λ��ȡ�ļ����ݣ������������еĸ�ʽ���ļ�
	 * @param in
	 */
	public static String readerFileByString(String fileName){
		BufferedReader reader = null;
		File file = new File(fileName);
		String tempstring= "";
		String tempstring1= "";
		//System.out.print("\r");
		try {
			
			//System.out.println("****************"+"\r"+"����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�ȡһ��");
			reader = new BufferedReader(new FileReader(file));
			//һ�ζ�ȡһ�У�ֱ������nullΪ�ļ�����
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
		//����һ��string���͵ı���ltempstring���ڴ��ÿ�δ��ļ��ж�ȡ����ÿ�е�����
		String ltempstring="";
		
		//�ڽ�ÿ�ζ�ȡ�����ļ����ݴ���List֮ǰ���ж�List���Ƿ��Ѿ����ڸ�����
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
	
	
	//��ʾ�������л�ʣ����ֽ���
	private static void showAvailableBytes(InputStream in) {
		// TODO Auto-generated method stub
		try {
			System.out.println("��ǰ�ֽ��������е��ֽ���Ϊ��"+in.available());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName = "E:\\Softwares\\jars\\appmodels.txt";
		//���շ���A��ȡ�ļ�����
		//ReadFromFile.readFileByByte(fileName);
		//���շ���B��ȡ�ļ�����
		//ReadFromFile.readFileByChar(fileName);
		//���շ���C��ȡ�ļ�����
		//System.out.println(ReadFromFile.readerFileByString(fileName));
		
		System.out.println(lreaderFileByString(fileName));
		
	}

}
