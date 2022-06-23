import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	private static void input(Scanner scanner) throws IOException {
		File file = new File("data");
		FileWriter fileWriter = new FileWriter(file, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		System.out.println("input mode : enter the word and meaning.");
		System.out.print("$ ");
		String pair = scanner.nextLine(); 
		
		while (!pair.equals("end")) {
			bufferedWriter.write(pair + "\n");
			System.out.print("$ ");
			pair = scanner.nextLine();
		}
		
		bufferedWriter.close();
	}
	
	private static void test(Scanner scanner) throws IOException {
		ArrayList<String> arrayList = read();
		System.out.println("test mode : enter the answer.");
		
		while (!arrayList.isEmpty()) {
			Random random = new Random();
			int index = random.nextInt(arrayList.size());
			String data = arrayList.get(index);
			String word = data.split(" ")[0];
			String meaning = data.split(" ")[1];
			
			System.out.print("$ " + word + " : ");
			String answer = scanner.nextLine();
			
			while (!meaning.equals(answer)) {
				System.out.print("$ " + word + " : ");	
				answer = scanner.nextLine();
			}
			
			arrayList.remove(index);
		}
		
	}
	
	private static ArrayList<String> read() throws IOException {
		ArrayList<String> arrayList = new ArrayList<>();
		FileReader fileReader = new FileReader("data");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String data = bufferedReader.readLine();
		
		while (data != null) {
			arrayList.add(data);
			data = bufferedReader.readLine();
		}
		
		bufferedReader.close();
		
		return arrayList;
	}
	
	private static void clear() throws IOException {
		File file = new File("data");
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.close();
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("main mode : enter the command.");
		
		System.out.print("$ ");
		String mode = scanner.nextLine();
		
		while (!mode.equals("quit")) {
			switch (mode) {
			case "input":
				input(scanner);
				break;
			case "test":
				test(scanner);
				break;
			case "clear":
				clear();
				break;
			}
			
			System.out.println("main mode : enter the command");
			System.out.print("$ ");
			mode = scanner.nextLine();
		}
		
		scanner.close();
	}
	
}
