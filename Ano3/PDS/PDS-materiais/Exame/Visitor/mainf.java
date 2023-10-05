package v5;


public class mainf {

	public static void main(String[] args) {
		if (args.length <= 0) {
			System.err.println("Input some args! Check them below!\n");
			System.out.println(
					"Usage:\n	java mainf [-option] path\n\tOption:\n\t\t-r: Include the size of the directories inside");
			System.exit(0);
		}

		if (args.length == 1) {
			new Visitador().Walker(args[0], false);

		} else if (args.length == 2) {
			if (args[0].equals("-r")) {
				new Visitador().Walker(args[1], true);
			} else {
				usage();
			}

		} else {
			usage();
		}

	}

	private static void usage() {
		System.err.println("Error!");
		System.out.println(
               "Usage:\n	java mainf [-option] path\n\tOption:\n\t\t-r: Include the size of the directories inside");
		System.exit(0);
	}

}