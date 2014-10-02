
public class Function {

	public void function(Integer[] array) {
		int iterations = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = array.length - 1; j >= i+1; j--){
				if (-1 == Integer.compare(array[j],array[j-1])) {
					Integer temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
				System.out.print("iteration#: " + iterations + " ");
				System.out.print("{ ");
				for (int x = 0; x < array.length; x++)
				{
					System.out.print(array[x] + ", ");
				}
				System.out.print(" }");
				System.out.println();
				iterations ++;
			}
		}
	}
	
	
}
