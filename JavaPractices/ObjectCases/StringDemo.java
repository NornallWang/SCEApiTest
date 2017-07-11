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
		System.out.println("判断是否引用同一空间:"+(s1==s2));
		System.out.println("equals进行比较两个引用的是否为同一个空间值，"+s1.equals(s2));
		
		String strA = new String("abcd");
		String strB = new String("abcd");
		System.out.println(strA == strB);
		System.out.println(strA.equals(strB));
		
		//indexOf
		System.out.println(str.indexOf("o"));	//首次出现的位置
		System.out.println(str.lastIndexOf("o"));	//最后一次出现的位置
		System.out.println(str.indexOf("o",5));
		
		System.out.println("\n字符串str的长度为：");
		System.out.println(str.length());
		
		System.out.println("\n使用replace方法进行字符替换：");
		System.out.println(str.replace("e", "a"));
		
		String strArr[] = str.split(",");
		System.out.println("\n以逗号进行分隔:");
		for(int i=0;i<strArr.length;i++){
			System.out.println(strArr[i]);
		}
		
		String[] arr = str.split(" ");
		System.out.println("\n以空格分隔:");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		System.out.println("\n使用subString进行字符串裁剪：");
		System.out.println(str.substring(5));
		System.out.println(str.substring(5, 9));
		
		System.out.println("\n进行大小写转换：");
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		
	}

}
