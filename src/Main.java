import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer> expenses = new ArrayList<>();

	// initializes expenses
	static {
		expenses.add(1000);
		expenses.add(2300);
		expenses.add(45000);
		expenses.add(32000);
		expenses.add(110);
	}

	public static void main(String[] args) {
		runApp();
	}

	public static void runApp() {
		System.out.println("\n**************************************\n");
		System.out.println("\tWelcome to TheDesk \n");
		System.out.println("**************************************");

		optionsSelection();
	}

	private static void optionsSelection() {
		String[] arr = { "1. I wish to review my expenditure", "2. I wish to add my expenditure",
				"3. I wish to delete my expenditure", "4. I wish to sort the expenditures",
				"5. I wish to search for a particular expenditure", "6. Close the application" };
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr[i]);
		}

		System.out.println("\nEnter your choice:\t");
		Scanner sc = new Scanner(System.in);
		int options = sc.nextInt();
		switch (options) {
		case 1:
			System.out.println("Your saved expenses are listed below: \n");
			System.out.println(expenses + "\n");
			optionsSelection();
			break;
		case 2:
			System.out.println("Enter the value to add your Expense: \n");
			int value = sc.nextInt();
			expenses.add(value);
			System.out.println("Your value is updated\n");
			System.out.println(expenses + "\n");
			optionsSelection();
			break;
		case 3:
			System.out.println(
					"You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
			int con_choice = sc.nextInt();
			if (con_choice == options) {
				expenses.clear();
				System.out.println(expenses + "\n");
				System.out.println("All your expenses are erased!\n");
			} else {
				System.out.println("Oops... try again!");
			}
			optionsSelection();
			break;
		case 4:
			sortExpenses();
			optionsSelection();
			break;
		case 5:
			System.out.println("Enter the expense to search\n");
			int target = sc.nextInt();
			searchExpenses(target);
			optionsSelection();
			break;
		case 6:
			closeApp();
			break;
		default:
			System.out.println("You have made an invalid choice!");
			System.out.println("Try again!");
			optionsSelection();
			break;
		}
		
		sc.close();
	}

	private static void closeApp() {
		System.out.println("Closing your application... \nThank you!");
	}

	private static void searchExpenses(int target) {
		int i = 0;
		for (int expense : expenses) {
			if (expense == target) {
				System.out.printf("Expense ($%d) found at position %d\n\n", expense, i);
				return;
			}
			i++;
		}

		System.out.printf("%d is not in the expenditure.\n", target);
	}

	private static void sortExpenses() {
		Collections.sort(expenses);
		System.out.println("Your expenses have been sorted:\n");
		System.out.println(expenses + "\n");
	}
}
