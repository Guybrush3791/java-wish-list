package org.generation.italy.christmas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static class StringComparator implements Comparator<String> {
		
		@Override
		public int compare(String o1, String o2) {
			
//			if (o1.length() > o2.length()) return -1;
//			else if (o1.length() < o2.length()) return 1;
//			
//			return 0;
			
			return o2.length() - o1.length();
		}
	}
	public static class VocalCouterComparator implements Comparator<String> {
		
		@Override
		public int compare(String o1, String o2) {
			
			return getVocalCount(o2) - getVocalCount(o1);
		}
		
		private int getVocalCount(String str) {
			
			List<Character> vocals = Arrays.asList(new Character[] {'a', 'e', 'i', 'o', 'u'});
			
			int vocalCounter = 0;
			for (Character c : str.toCharArray()) {
				
				c = Character.toLowerCase(c);
				
				if (vocals.contains(c)) {
					
					vocalCounter++;
				}
			}
			
			return vocalCounter;
		}
	}
	public static class InverseCharComparator implements Comparator<Character> {
		
		@Override
		public int compare(Character o1, Character o2) {
			
			return (int) o2 - (int) o1;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		List<String> desideri = new ArrayList<>();
//		
//		while(true) {
//			
//			System.out.print("Vuoi inserire un nuovo desiderio? y/n  ");
//			String res = sc.nextLine();
//			
//			if (res.toLowerCase().equals("y")) {
//				
//				System.out.println("Quale altro desiderio vuoi inserire?");
//				String desiderio = sc.nextLine();
//				
//				desideri.add(desiderio);
//				
//				System.out.println("La nuova lista ha lunghezza: " + desideri.size());
//				
//				continue;
//			}
//			
//			break;
//		}
//		
//		System.out.println(desideri);
//		System.out.println("-------------------------");
//		
//		desideri.sort(new VocalCouterComparator());		
//		System.out.println(desideri);
		
//		---------------------------------------------------
		
		System.out.println("Dimmi una frase: ");
		String frase = sc.nextLine();
		
		Set<Character> charter = new HashSet<>();
		for (Character c : frase.toCharArray()) {
			
			charter.add(c);
		}
		System.out.println(charter);
		List<Character> charterList = new ArrayList<>(charter);
		charterList.sort(new InverseCharComparator());
		System.out.println(charterList);
		
//		---------------------------------------------------
		
		Map<Character, Integer> charFreq = new HashMap<>();
		for (Character c : frase.toCharArray()) {
			
			if (charFreq.containsKey(c)) {
				
				int oldFreq = charFreq.get(c);
				charFreq.put(c, oldFreq + 1);
			} else {
				
				charFreq.put(c, 1);
			}
		}
		System.out.println(charFreq);
		
		System.out.println("-------------------------");
		
		List<Character> charterKeys = new ArrayList<>(charFreq.keySet());
		charterKeys.sort(new InverseCharComparator());
		for (Character c : charterKeys) {
			
			System.out.println(c + " --> " + charFreq.get(c));
		}		
	}
}








