package ObjectCases;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello John, Mary, you guys are my best friends!";
		System.out.println(str.charAt(18));
		
		String str2 = "hello";
		System.out.println(str.compareTo(str2));
		
		System.out.println(str.concat(str2));
		System.out.println(str);
		
		String newStr = str + "I lied!";
		System.out.println(newStr);
		System.out.println(str);

		System.out.println(str.contains("friends"));
		System.out.println(str.endsWith("friends!"));
		System.out.println(str.endsWith("friends"));
		System.out.println(str.startsWith("Hello"));
		System.out.println(str.startsWith("hello"));
		
		String s1 = "abcd";
		String s2 = "abcd";
		System.out.println("�ж��Ƿ�����ͬһ�ռ�:"+(s1==s2));
		System.out.println("equals���бȽ��������õ��Ƿ�Ϊͬһ���ռ�ֵ��"+s1.equals(s2));
		
		String strA = new String("abcd");
		String strB = new String("abcd");
		System.out.println(strA == strB);
		System.out.println(strA.equals(strB));
		
		//indexOf
		System.out.println(str.indexOf("o"));	//�״γ��ֵ�λ��
		System.out.println(str.lastIndexOf("o"));	//���һ�γ��ֵ�λ��
		System.out.println(str.indexOf("o",5));
		
		System.out.println("\n�ַ���str�ĳ���Ϊ��");
		System.out.println(str.length());
		
		System.out.println("\nʹ��replace���������ַ��滻��");
		System.out.println(str.replace("e", "a"));
		
		String strArr[] = str.split(",");
		System.out.println("\n�Զ��Ž��зָ�:");
		for(int i=0;i<strArr.length;i++){
			System.out.println(strArr[i]);
		}
		
		String[] arr = str.split(" ");
		System.out.println("\n�Կո�ָ�:");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		System.out.println("\nʹ��subString�����ַ����ü���");
		System.out.println(str.substring(5));
		System.out.println(str.substring(5, 9));
		
		System.out.println("\n���д�Сдת����");
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		
	}

}
