/*
* Jacky Li
* 09/20/2021
* Different ways of sorting array
*/
public class Sorting {
	static int array[] = new int [25];

	public static void main(String[] args) {

		for (int i = 0; i < 25; i++){
			array [i] = (int)(Math.random()*1000+1);
			System.out.println (array[i]);
		}

		System.out.println();
		Sorting2();
	}


//	public static void Sorting(){
//		int temp;
//
//		for (int x = 0; x<25 ; x++){
//			for (int i = 0; i<24; i++){
//				if (array[i]>array[i+1]){
//					temp = array[i];
//					array[i] = array[i+1];
//					array[i+1] = temp;
//				}
//			}
//		}
//		for (int i : array){
//			System.out.println(i);
//		}
//	}

	public static void Sorting2(){
		int minIndex;
		int count = 0;
		int temp;

		for (int i = 0; i < 24 ; i++){
			minIndex = i;
			count++;
			for (int x = count; x < 25; x++){
				if (array[x] < array[minIndex]){
					minIndex = x;
				}

			}
			temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}

		for (int i = 0; i < 25 ; i++){
			System.out.println(array[i]);
		}


	}

}