//$Id$
package practice;

import java.util.HashMap;

public class practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a ="fcrxzwscanmligyxyvym", b="jxwtrhvujlmrpdoqbisbwhmgpmeoke";
//		String a ="showman", b="woman";
		HashMap<Character,Integer> a1 = new HashMap<>();
		HashMap<Character,Integer> b1 = new HashMap<>();
		for(int i=0;i<a.length();i++){
			if(a1.containsKey(a.charAt(i))){
				int key = a1.get(a.charAt(i));
				a1.put(a.charAt(i), key+1);
			}else{
				a1.put(a.charAt(i), 1);
			}
		}
		for(int i=0;i<b.length();i++){
			if(b1.containsKey(b.charAt(i))){
				int key = b1.get(b.charAt(i));
				b1.put(b.charAt(i), key+1);
			}else{
				b1.put(b.charAt(i), 1);
			}
		}
		int count=0;
        for(Character key: a1.keySet()){
        	if(!b1.containsKey(key)){
        		count = count + a1.get(key);
        	}else{
        		count = count + Math.abs(b1.get(key)-a1.get(key));
        		a1.put(key, 0);
        		b1.remove(key);
        		
        	}
        }
        for(Character key: b1.keySet()){
        	if(!a1.containsKey(key) ){
        		count=count+b1.get(key);
        	}else{
        		count = count + Math.abs(b1.get(key)-a1.get(key));
        	}
        }
//        System.out.println(a1);
//        System.out.println(b1);
        System.out.println(count);
	}

}
